package FileAndIO.流.转换流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java.io.Writer
 *       继承者 java.io.OutputStreamWriter
 * OutputStreamWriter:是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节（编码）
 *
 * 继承自父类的共性成员方法：
 *      abstract  void close()  关闭此流，但要先刷新它。
 *      abstract  void flush()   刷新该流的缓冲。
 *      void write(char[] cbuf)   写入字符数组。
 *      abstract  void write(char[] cbuf, int off, int len)  写入字符数组的某一部分。
 *      void write(int c)  写入单个字符。
 *      void write(String str)  写入字符串。
 *      void write(String str, int off, int len)  写入字符串的某一部分。
 *
 * 构造方法：
 *  OutputStreamWriter(OutputStream out)  创建使用默认字符编码的 OutputStreamWriter。
 *  OutputStreamWriter(OutputStream out, String charsetName)  创建使用指定字符集的 OutputStreamWriter。
 *
 *  参数：
 *      OutputStream out：字节输出流，用来写转换之后的字节到文件中
 *      String charsetName：编码表名称，不区分大小写，默认UTF-8
 *  使用步骤：
 *      1.创建一个OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称
 *      2.使用OutputStreamWriter对象中的方法writer，把字符转换为字节存储到缓冲区中(编码)
 *      3.使用OutputStreamWriter对象中的flush把内存缓冲区中的字节刷新到文件中(使用字节流写字节的过程)
 *      4.释放资源
 */
public class Demo02OutputStreamReader {
    public static void main(String[] args) throws IOException {
        //writer_utf_8();
        writer_gbk();
    }

    private static void writer_gbk() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\LJF\\2.txt"),
                "GBK");
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    /**
     * 使用转换流OutputStreamWriter写utf-8文件
     */
    private static void writer_utf_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\LJF\\1.txt"),
                "UTF-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
