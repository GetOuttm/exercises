package ScoketDemo.BS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建B/S版本的TCP服务器
 */
public class TCPServerThread {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket，和系统指定的端口号
        ServerSocket serverSocket = new ServerSocket(8080);

        /*
            浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独开启一个线程，让他读取服务器的图片
            让服务器一直处于监听状态，客户端请求一次，服务器就会写一次
         */
        while (true) {
            //使用SocketServer对象中的方法accept获取请求的客户端对象浏览器
            Socket socket = serverSocket.accept();


            //开启线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //使用Socket对象中getInputStream获取网络字节输入流
                        InputStream inputStream = socket.getInputStream();
                        //使用网络字节输入流InputStream对象中的方法read，读取客户端的请求信息
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = inputStream.read(bytes)) != -1) {
//            System.out.println(new String(bytes,0,len));
//        }

                        //把网络字节输入流转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                        //把客户端请求信息的第一行读取出来
                        String s = br.readLine();
                        System.err.println(s);
                        String[] arr = s.split(" ");
                        String htmlPath = arr[1].substring(1);
                        System.err.println(htmlPath);

                        //创建本地字节输入流，构造方法中绑定要读取的路径
                        FileInputStream fis = new FileInputStream(htmlPath);
                        //使用Socket中的getOutputStream获取网络字节输出流对象OutputStream
                        OutputStream outputStream = socket.getOutputStream();

                        //写入HTTP协议响应头，固定写法
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\r\n".getBytes());
                        //必须写入空行，否则浏览器不解析
                        outputStream.write("\r\n".getBytes());

                        //一读一写复制文件，把服务器的html文件写入到浏览器
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = fis.read(bytes)) != -1) {
                            outputStream.write(bytes,0,len);
                        }

                        fis.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
