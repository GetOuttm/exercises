package com.es;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.cluster.health.ClusterIndexHealth;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticserachTest {


    /**
     * 创建索引库
     * @throws Exception
     */
    @Test
    public void createIndex() throws Exception {
        //创建一个settings对象，相当于是一个配置信息，只要是集群的名称
        Settings settings = Settings.builder().put("cluster.name","my-es").build();

        //创建一个客户但client对象
        /*BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("posts").id("1")
                .source(XContentType.JSON,"field", "foo"));//将第一个索引请求添加到批量请求中
        request.add(new IndexRequest("posts").id("2")
                .source(XContentType.JSON,"field", "bar"));//添加第二个索引请求
        request.add(new IndexRequest("posts").id("3")
                .source(XContentType.JSON,"field", "baz"));//添加第三个索引请求*/
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302));

        //使用client对象创建一个索引库
        client.admin().indices().prepareCreate("hello")
                //执行操作
                .get();

        //关闭client对象
        client.close();
    }

    @Test
    public void test45() throws UnknownHostException {
            //1、指定es集群  cluster.name 是固定的key值，my-application是ES集群的名称
            Settings settings = Settings.builder().put("cluster.name", "my-application").build();
            //2.创建访问ES服务器的客户端
            TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301));
            //获取集群信息
            ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().get();
            //获取集群名称
            String clusterName = healthResponse.getClusterName();
            System.out.println(clusterName);
            //获取存放数据的那些节点
            int numberOfDataNodes = healthResponse.getNumberOfDataNodes();
            System.out.println(numberOfDataNodes);
            //获取节点的总数量
            int numberOfNodes = healthResponse.getNumberOfNodes();
            System.out.println(numberOfNodes);
            //获取集群中一共有多少索引
            for(
            ClusterIndexHealth health:healthResponse.getIndices().values()) {
                String index = health.getIndex();//当前索引名称
                int numberOfShards = health.getNumberOfShards();//主分片
                int numberOfReplicas = health.getNumberOfReplicas();//副本
                ClusterHealthStatus status = health.getStatus();//得到当前的健康状况
                System.out.println(status);//健康-绿色  一般-黄色  不健康-红色
            }

    }
}
