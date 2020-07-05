package FileAndIO.流.缓冲流.字节;

import java.io.*;

/**
 * java.io.OutputStream
 *       继承者 java.io.FilterOutputStream
 *           继承者 java.io.BufferedOutputStream
 *
 * BufferedOutputStream：字节缓冲输出流
 * 继承自父类的共性成员方法：
 *      void close()  关闭此输出流并释放与此流有关的所有系统资源。
 *      void flush() 刷新此输出流并强制写出所有缓冲的输出字节。
 *      void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
 *      void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *      abstract  void write(int b) 将指定的字节写入此输出流。
 * 构造方法：
 *      BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
 *      BufferedOutputStream(OutputStream out, int size) 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
 *        参数：
 *          OutputStream out：字节输出流，可以传递FileOutputStream，缓冲流会给FileOutputStream增加一个缓冲区
 *              提高FileOutputStream的写入效率
 *          int size：缓冲区大小，不指定就是默认大小
 *  使用步骤：
 *      1.创建FileOutputStream(字节输出流对象)，构造方法中绑定要输出的目的地
 *      2.创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream对象效率
 *      3.使用BufferedOutputStream对象的中的方法write，把数据写入到内部缓存区中
 *      4.使用BufferedOutputStream对象中的方法flush，把内部缓冲区中的数据刷新到文件中
 *      5.释放资源(close会先调用flush刷新数据，第四部可以省略)
 */
public class Demo01BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("F:\\LJF\\qq.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("我把数据写入到内存缓冲区中".getBytes());
        bos.flush();
        bos.close();
    }
}
