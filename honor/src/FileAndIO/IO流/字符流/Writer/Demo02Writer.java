package FileAndIO.IO流.字符流.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流写数据的其他方法
 *          void write(char[] cbuf)   写入字符数组。
 *          abstract  void write(char[] cbuf, int off, int len)  写入字符数组的某一部分。
 *          void write(String str)  写入字符串。
 *          void write(String str, int off, int len)  写入字符串的某一部分。
 */
public class Demo02Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\LJF\\t.txt");
        //void write(char[] cbuf)   写入字符数组。
        char[] chars = {'a','b','c','d','e','f','g'};
        fw.write(chars);

        //abstract  void write(char[] cbuf, int off, int len)  写入字符数组的某一部分。
        fw.write(chars,1,4);


        //void write(String str)  写入字符串。
        fw.write("李锦峰");

        //void write(String str, int off, int len)  写入字符串的某一部分。
        fw.write("中国移动",1,3);

        fw.close();
    }
}
