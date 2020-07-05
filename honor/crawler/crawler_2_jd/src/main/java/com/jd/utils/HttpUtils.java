package com.jd.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 封装HttpClient
 */
@Component
public class HttpUtils {

    //声明连接池
    private PoolingHttpClientConnectionManager  clientConnectionManager;

    public HttpUtils() {
        this.clientConnectionManager = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        this.clientConnectionManager.setMaxTotal(100);
        //设置每个主机的最大连接数
        this.clientConnectionManager.setDefaultMaxPerRoute(10);
    }

    /**
     * 根据请求地址下载页面数据
     * @param url
     * @return  页面数据
     */
    public String doGetHtml(String url) {
        //获取httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.clientConnectionManager).build();

        //设置httpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        //设置请求信息
        httpGet.setConfig(this.getConfig());

        //设置请求Request Headers中的User-Agent，告诉京东说我这是浏览器访问，您只需要做一个安静的美男子就够了
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");

        //使用HttpClient发起请求，获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应头Entity是否为空，不为空就可以使用EntityUtils
                if (response.getEntity() != null) {
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
//                    return String.valueOf(httpGet);
                    return content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭response
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //返回空
        return "";
    }


    /**
     * 下载图片
     * @param url
     * @return  图片名称
     */
    public String doGetImage(String url) {
        //获取httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.clientConnectionManager).build();

        //设置httpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        //设置请求信息
        httpGet.setConfig(this.getConfig());

        //使用HttpClient发起请求，获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应头Entity是否为空，不为空就可以使用EntityUtils
                if (response.getEntity() != null) {
                    //下载图片
                    //获取图片后缀，
                    String extName = url.substring(url.lastIndexOf("."));

                    //创建图片名。重命名图片
                    String picName = UUID.randomUUID().toString() + extName;

                    //下载图片
                    //声明outputStream
                    OutputStream outputStream = new FileOutputStream(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\image\\" + picName));
                    response.getEntity().writeTo(outputStream);
                    //返回图片名称
                    return picName;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭response
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //下载失败返回空
        return "";
    }


    /**
     * 设置请求信息
     * @return
     */
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000)   //创建连接得最长时间
                .setConnectionRequestTimeout(500) //获取连接得最长时间
                .setSocketTimeout(100000) //数据传输得最长时间
                .build();
        return config;
    }
}
