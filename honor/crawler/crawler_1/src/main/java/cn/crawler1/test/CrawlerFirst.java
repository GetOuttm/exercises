package cn.crawler1.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 爬虫入门
 */
public class CrawlerFirst {

    public static void main(String[] args) throws IOException {
        //1.打开浏览器，创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2.输入网址，发起get请求创建httppget对象
        HttpGet httpGet = new HttpGet("http://www.itheima.com/");

        //3.按回车，发起请求，返回响应
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4.解析响应获取数据
        //判断状态码是否是200
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "utf-8");
            System.out.println(content);
        }
    }
}
