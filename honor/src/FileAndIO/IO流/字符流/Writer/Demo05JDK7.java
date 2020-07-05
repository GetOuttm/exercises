package FileAndIO.IO流.字符流.Writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * jdk1.7的新特性
 * 在try的后面可以增加括号，在括号里定义流对象
 * 那么这个流对象的作用域只在try中有效
 * try中的代码执行完毕，会把流对象释放，不用再写finally
 *       try(定义流对象;流对象 ....){
 *           可能会产生异常的代码
 *       } catch(异常类的变量 变量名) {
 *           异常的处理逻辑
 *       }
 */
public class Demo05JDK7 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("C:\\a.jpg");
            FileOutputStream fos = new FileOutputStream("F:\\LJF\\a.jpg");) {
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
