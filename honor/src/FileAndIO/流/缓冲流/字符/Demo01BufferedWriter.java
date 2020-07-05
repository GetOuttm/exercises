package FileAndIO.流.缓冲流.字符;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * java.io.Writer
 *       继承者 java.io.BufferedWriter
 * BufferedWriter:字符缓冲输出流
 *  继承自父类的共性成员方法：
 *      abstract  void close()  关闭此流，但要先刷新它。
 *      abstract  void flush()   刷新该流的缓冲。
 *      void write(char[] cbuf)   写入字符数组。
 *      abstract  void write(char[] cbuf, int off, int len)  写入字符数组的某一部分。
 *      void write(int c)  写入单个字符。
 *      void write(String str)  写入字符串。
 *      void write(String str, int off, int len)  写入字符串的某一部分。
 * 构造方法：
 *  BufferedWriter(Writer out)  创建一个使用默认大小输出缓冲区的缓冲字符输出流。
 *  BufferedWriter(Writer out, int sz)  创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
 *  参数：
 *      Writer out：字符输出流，可以传递FileWriter，缓冲流会给FileWriter增加一个缓冲区
 *                提高FileWriter的写入效率
 *     int sz：缓冲区大小，不指定就是默认大小
 *
 *  特有的成员方法：
 *       void newLine()  写入一个行分隔符。
 *          会根据不同的操作系统获取不同的行分隔符
 *  使用步骤：
 *      1.创建字符缓冲输出流，构造方法中传递字符输出流
 *      2.调用字符缓冲流的方法writer，把数据写入到内存中
 *      3.调用字符缓冲输出流的方法flush，把内存缓冲区中的数据刷新到文件中
 *      4.释放资源
 */
public class Demo01BufferedWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\LJF\\ww.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < 10; i++) {
            bw.write("李锦峰");
//            bw.write("\r\n");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
