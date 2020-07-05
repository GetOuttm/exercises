package FileAndIO.IO流.字符流.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * jdk1.7之前使用try/catch/finally处理流中的异常
 *      try{
 *          可能会产生异常的代码
 *      } catch(异常类的变量 变量名) {
 *          异常的处理逻辑
 *      } finally {
 *          一定会执行的代码
 *          资源释放等
 *      }
 */
public class Demo04WriterException {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\LJF\\q.txt");
            for (int i = 0; i < 10; i++) {
                fw.write("HelloWorld" + i + "\r\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            //创建对象失败，fw的 默认值是null，null是无法调用方法的，会抛出NullPointerException异常，所以需要加判断
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }

    }
}
