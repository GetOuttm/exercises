package cn.crawler1.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient-GET
 */
public class HttpGetTest {

    public static void main(String[] args) {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建httpget请求，设置url访问地址
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");

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
