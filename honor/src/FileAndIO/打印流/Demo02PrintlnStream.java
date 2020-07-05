package FileAndIO.打印流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 可以改变输出语句的目的地(打印流的方法)
 * 输出语句默认在控制台打印
 * 使用System中的setOut方法改变输出语句的目的地改为参数传递的打印流的目的地
 *  static void setOut(PrintStream out)   重新分配“标准”输出流。
 */
public class Demo02PrintlnStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我在控制台输出");

        PrintStream ps = new PrintStream("F:\\LJF\\目的地是打印流.txt");
        System.setOut(ps);
        System.out.println("我在打印流的目的地输出");

        ps.close();
    }
}
