package FileAndIO.IO流.字符流.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 续写和换行
 * 续写：追加写，使用两个参数的构造方法
 *      FileWriter(File file, boolean append) 根据给定的 File 对象构造一个 FileWriter 对象。
 *      FileWriter(String fileName, boolean append) 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
 *   参数：
 *      File file,String fileName:写入数据的目的地
 *      boolean append：续写开关 true：不会创建新的文件覆盖原文件，可以续写
 *                              false：会创新新的文件，不能续写
 *    写换行：写换行符号
 *       windows：\r\n
 *       linux：\n
 *       mac:\r
 */
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\LJF\\q.txt");
        for (int i = 0; i < 10; i++) {
            fw.write("HelloWorld" + i + "\r\n");
        }
        fw.close();
    }
}
