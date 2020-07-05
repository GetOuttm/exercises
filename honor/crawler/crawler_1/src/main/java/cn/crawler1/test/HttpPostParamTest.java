package cn.crawler1.test;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HttpClient-POST  带参数
 */
public class HttpPostParamTest {

    public static void main(String[] args) throws Exception {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建httpget请求，设置url访问地址
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");
        //声明list集合，封装表单中的参数
        List<NameValuePair> pairs = new ArrayList<>();
        //设置请求地址
        pairs.add(new BasicNameValuePair("keys","java"));
        //创建表单中的entity对象   第一个参数是封装好的表单数据，第二个就是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(pairs,"utf-8");
        //设置表单的entity对象到post请求中
        httpPost.setEntity(formEntity);

        System.out.println("发起请求的信息" + httpPost);

        CloseableHttpResponse response = null;
        try {
            //使用httpclient发起请求。获取response
            response = httpClient.execute(httpPost);

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
