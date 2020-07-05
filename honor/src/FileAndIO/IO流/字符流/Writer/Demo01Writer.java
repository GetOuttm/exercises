package FileAndIO.IO流.字符流.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * java.io.Writer:字符输出流，是所有字符输出流的最顶层父类，是一个抽象类
 *      共性的成员方法
 *          abstract  void close()  关闭此流，但要先刷新它。
 *          abstract  void flush()   刷新该流的缓冲。
 *          void write(char[] cbuf)   写入字符数组。
 *          abstract  void write(char[] cbuf, int off, int len)  写入字符数组的某一部分。
 *          void write(int c)  写入单个字符。
 *          void write(String str)  写入字符串。
 *          void write(String str, int off, int len)  写入字符串的某一部分。
 *
 * java.io.Writer
 *       继承者 java.io.OutputStreamWriter
 *           继承者 java.io.FileWriter
 *
 *    FileWriter：文件字符输出流，把内存中的数据写入到文件中
 *    构造方法:
 *      FileWriter(File file)  根据给定的 File 对象构造一个 FileWriter 对象。
 *      FileWriter(String fileName)  根据给定的文件名构造一个 FileWriter 对象。
 *   参数：写入数据的目的地
 *      String fileName：文件的路径
 *      File file：一个文件
 *   构造方法的作用
 *      1.会创建一个FileWriter对象
 *      2.会根据给定的构造方法中传递的文件/文件的路径，创建文件
 *      3.会把FileWriter对象指向创建好的文件
 *
 *   FileWriter字符书橱里的使用步骤
 *      1.创建FileWriter对象，构造方法中绑定要写入数据的目的地
 *      2.创建FileWriter中的方法writer把数据写入到内存缓冲区中(字符转换为自己的过程)
 *      3.使FileWriter中的方法flush，把内存缓冲区中的数据刷新到文件中
 *      4.释放资源(会先把内存缓冲区中的数据刷新到文件中)
 */
public class Demo01Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\LJF\\dd.txt");
        fw.write(97);
//        fw.flush();
        fw.close();
    }
}
