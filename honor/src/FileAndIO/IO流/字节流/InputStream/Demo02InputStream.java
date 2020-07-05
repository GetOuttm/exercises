package FileAndIO.IO流.字节流.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节输入流一次性读取多个字节的方法：
 *       int read(byte[] b) 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
 * 明确两件事：
 *      1.方法的参数byte[]的作用是什么？
 *      2.返回值int是什么？
 */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\LJF\\c.txt");

//        byte[] bytes = new byte[2];
//        int read = fis.read(bytes);
//        System.out.println(read);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }


        fis.close();
    }
}
