package ScoketDemo.案例_文件上传;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传案例服务器：读取客户端上传的文件，保存到服务器硬盘，给客户端回复"上传成功"
 *
 * 明确：
 *      数据源:客户端上传的文件
 *      目的地：服务器的硬盘地址 F:\\LJF\\b.MP4
 *
 * 步骤：
 *  1.创建服务器ServerSocket对象，和系统要指定的端口号
 *  2.使用SocketServer对象中的方法accept获取请求的客户端对象socket
 *  3.使用Socket对象中getInputStream获取网络字节输入流
 *  4.判断F:\\LJF文件夹是否存在，不存在创建
 *  5.创建一个FileOutputStreamv本地字节输出流，构造方法中绑定要输出的目的地
 *  6.使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
 *  7.使用ileOutputStreamv本地字节输出流中的writer把读取到文件保存到服务器上
 *  8.使用Socket对象中getOutputStream方法获取网络字节输出流
 *  9.使用网络字节输出流OutputStream对象中的方法writer给客户端回写数据
 *  10.释放资源 FileOutputStream socket  ServerSocket
 */
public class FileUploadTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        File file = new File("F:\\LJF");
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file + "\\c.MP4");
        byte[] bytes = new byte[1024];
        int len = 0;
        /**
         * 从此输入流中读取一个数据字节。如果没有输入可用，则此方法将阻塞。
         * 没有停止就是以为阻塞了
         * 读取客户端上传的文件时，永远不会读取到结束标记
         * read方法进入阻塞状态，一直死循环等待结束标记
         * 8910就不会执行到，也不会给客户端回写
         */
        while ((len = inputStream.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
      socket.getOutputStream().write("上传成功".getBytes());

        fos.close();
        serverSocket.close();
        socket.close();
    }
}
