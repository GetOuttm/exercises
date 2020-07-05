package FileAndIO.打印流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * java.io.OutputStream
 *       继承者 java.io.FilterOutputStream
 *           继承者 java.io.PrintStream
 * PrintStream：打印流
 *      PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
 *      特点：
 *          1.只负责数据的输出不负责数据的读取
 *          2.与其他输出流不同，PrintStream 永远不会抛出 IOException
 *          3.有特有的方法：print，println
 *               void print(任意类型的值)
 *               void println(任意类型的值并换行)
 *   构造方法：
 *      PrintStream(File file) 创建具有指定文件且不带自动行刷新的新打印流。
 *      PrintStream(OutputStream out)  创建新的打印流。
 *      PrintStream(String fileName)  创建具有指定文件名称且不带自动行刷新的新打印流。
 *  注意：
 *      如果使用父类的writer方法写数据，那么查看数据时会查询编码表
 *      如果要使用自己特有的方法写数据，写的数据原样输出
 */
public class DemoPrintlnStream {
    public static void main(String[] args) throws FileNotFoundException {
        //创建一个打印流对象，构造方法中绑定要输出的目的地
        PrintStream ps = new PrintStream("F:\\LJF\\println.txt");
        //用父类共性的方法
        ps.write(97);
        //用自己特有的方法
        ps.println(97);
        ps.println('w');
        ps.println("我");
        ps.println(12.23);
        ps.close();
    }
}
