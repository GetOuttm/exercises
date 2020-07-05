package ScoketDemo.案例_文件上传.优化;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

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
 *  5.创建一个FileOutputStream本地字节输出流，构造方法中绑定要输出的目的地
 *  6.使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
 *  7.使用ileOutputStreamv本地字节输出流中的writer把读取到文件保存到服务器上
 *  8.使用Socket对象中getOutputStream方法获取网络字节输出流
 *  9.使用网络字节输出流OutputStream对象中的方法writer给客户端回写数据
 *  10.释放资源 FileOutputStream socket  ServerSocket
 */
public class FileUploadTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        /*
            让服务器一直处于监听状态(死循环accept方法)
            有一个客户端上传文件就保存到服务器
         */

        while (true) {
            Socket socket = serverSocket.accept();

            /**
             * 使用多线程技术，提高程序的效率
             * 只要有一个客户上传文件我就开启一个线程，完成文件的上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        File file = new File("F:\\LJF");
                        if (!file.exists()) {
                            file.mkdirs();
                        }

                        /**
                         * 自定义一个文件命名规则，防止同名的文件覆盖
                         * 规则：域名+毫秒值+随机数
                         */
                        String str = "\\ljf" + System.currentTimeMillis() + new Random().nextInt(9999999) + ".MP4";

                        FileOutputStream fos = new FileOutputStream(file + str);
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
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    } finally {

                    }
                }
            }).start();
        }

        //服务器就不用关闭了
        //serverSocket.close();
    }
}
