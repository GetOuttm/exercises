package ScoketDemo.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP通信的客户端。向服务器发送连接请求，给服务器端发送数据，读取服务器回写的数据
 * 表示客户端的类
 *      java.net.Socket:此类实现客户端套接字（也可以就叫“套接字”）。套接字是两台机器间通信的端点。
 *      套接字：
 *          包含了IP地址和端口号的网络单位
 *  构造方法：
 *      Socket(String host, int port)  创建一个流套接字并将其连接到指定主机上的指定端口号。
 *      参数：
 *          String host：服务器主机的名称/服务器的ip地址
 *          int port：服务器的端口号
 *  成员方法：
 *      OutputStream getOutputStream()返回此套接字的输出流。
 *      InputStream getInputStream()  返回此套接字的输入流。
 *      void close()  关闭此套接字。
 * 实现步骤：
 *      1.创建一个客户端对象Socket，构造方法中绑定服务器的IP地址和端口号
 *      2.使用Socket对象中getOutputStream方法获取网络字节输出流
 *      3.使用网络字节输出流OutputStream对象中的方法writer给服务器发送数据
 *      4.使用Socket对象中getInputStream获取网络字节输入流
 *      5.使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
 *      6.释放资源  socket.close();
 *  注意事项：
 *      1.客户端和服务器端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
 *      2.当创建客户端对象Socket的时候，会请求服务器和服务器讲过三次握手创建连接通路
 *          这时如果服务器没有启动，就会抛出异常(java.net.ConnectException)，如果已经启动就可以进行交互
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好!".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        socket.close();
    }
}
