package cn.crawler1.test;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient请求参数
 */
public class HttpConfigTest {

    public static void main(String[] args) {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建httpget请求，设置url访问地址
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");

        //配置请求信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)//创建链接的最大时间，单位是毫秒
                        .setConnectionRequestTimeout(500)//设置获取连接的最长时间，单位毫秒
                        .setSocketTimeout(10*1000)//设置数据传输的最长时间，单位毫秒
                        .build();
        //给请求设置请求信息
        httpGet.setConfig(config);


        CloseableHttpResponse response = null;
        try {
            //使用httpclient发起请求。获取response
            response = httpClient.execute(httpGet);

            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
