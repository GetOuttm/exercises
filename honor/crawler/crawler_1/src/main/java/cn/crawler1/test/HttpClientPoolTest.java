package cn.crawler1.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient连接池
 */
public class HttpClientPoolTest {

    public static void main(String[] args) {
        //创建连接池管理器
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        connectionManager.setMaxTotal(100);

        //设置每个主机的最大连接数   每个主机均衡使用
        connectionManager.setDefaultMaxPerRoute(10);

        //使用连接池管理器发起请求
        doGet(connectionManager);
        doGet(connectionManager);
    }

    private static void doGet(PoolingHttpClientConnectionManager connectionManager) {
        //不是每次创建新的httpclient，而是从连接池中获取
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();

        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");
        System.out.println(httpGet);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //不能关闭httpclient，因为由连接池提供的
        }
    }

}
