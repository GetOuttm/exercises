package ScoketDemo.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通信的服务端：接受客户端的请求读取客户端发送的数据，给客户端回写数据
 *  表示服务器的类：
 *      java.net.ServerSocket：此类实现服务器套接字
 *  构造方法：
 *      ServerSocket(int port)  创建绑定到特定端口的服务器套接字。
 *      参数：int port：端口号
 *      服务器端必须明确知道是哪个客户端请求的服务器，所以可以使用accept方法获取到请求的客户端对象Socket
 *  成员方法：
 *      Socket accept()   侦听并接受到此套接字的连接。
 *
 *  实现步骤：
 *      1.创建服务器ServerSocket对象，和系统要指定的端口号
 *      2.使用SocketServer对象中的方法accept获取请求的客户端对象socket
 *      3.使用Socket对象中getInputStream获取网络字节输入流
 *      4.使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
 *      5.使用Socket对象中getOutputStream方法获取网络字节输出流
 *      6.使用网络字节输出流OutputStream对象中的方法writer给客户端回写数据
 *      7.释放资源  socket  ServerSocket
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("嗯。在的".getBytes());

        socket.close();
        serverSocket.close();
    }
}
