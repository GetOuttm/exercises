package ScoketDemo.案例_文件上传.优化;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
 *  明确：
 *      数据源：F:\\a.MP4
 *      目的地：服务器
 *  实现步骤：
 *      1.创建本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
 *      2.创建Socket客户端对象，构造方法中绑定服务器的IP地址和端口号
 *      3.使用Socket中的方法getOutputStream获取网络字节输出流对象
 *      4.使用本地的字节输入流FileInputStream对象中的方法read，读取本地文件
 *      5.使用网络字节输出流OutputStream对象中的方法writer把读取到的文件上传到服务器
 *      6.使用Socket中的方法getInputStream获取网络字节输入流InputStream对象
 *      7.使用网络字节输入流InputStream对象中的方法读取服务器回写的数据
 *      8.释放资源
 *          FileInputStream，Socket
 */
public class FileUploadTcpClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\a.MP4");
        Socket socket = new Socket("127.0.0.1",8888);

        OutputStream outputStream = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        /*
        while循环路不会读取到-1，那么也不会把结束标记写入服务器
         */
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes,0,len);
        }
        /**
         * 解决上传文件给文件写一个结束标记
         *  void shutdownOutput()  禁用此套接字的输出流。
         *  禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
         */
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        //读取不到服务器回写的数据
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
