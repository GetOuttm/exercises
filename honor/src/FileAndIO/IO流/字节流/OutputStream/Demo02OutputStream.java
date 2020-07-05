package FileAndIO.IO流.字节流.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 一次写多个字节的方法
 *   void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
 *   void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("F:\\LJF\\b.txt"));

        fos.write(49);
        fos.write(48);
        fos.write(48);

        /**
         * void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
         *  一次写入多个字节
         *      如果第一个数是正数(0-127),那么显示的时候会查询ASCII表
         *      如果第一个数是负数，那第一个数会和第二个数组成一个中文显示，查询系统默认(GBK)
         */
        byte[] bytes = {68,69,45,62,23};
//        byte[] bytes = {-68,69,45,62,23};

        /**
         * void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
         * 字节数组的一部分写入文件
         *      int off：数组的开始索引
         *      int lem：写几个字节
         */
        fos.write(bytes,2,3);

        /**
         * 写入字符的方法：可以使用String类中的方法把字符串转换为字节数组
         *  byte[] getBytes() 把字符串转换为字节数组
         */
        byte[] bytes1 = "您好".getBytes();
        System.out.println(Arrays.toString(bytes1));
        fos.write(bytes1);

        fos.close();

    }
}
