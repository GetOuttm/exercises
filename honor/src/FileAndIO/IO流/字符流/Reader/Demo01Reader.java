package FileAndIO.IO流.字符流.Reader;

import java.io.FileReader;
import java.io.IOException;

/**
 * java.io.Reader 字符输入流
 *      是字符输入流的最顶层父类，定义了一些共性的成员方法，是一个抽象类。
 * 共性的成员方法：
 *   int read()读取单个字符。
 *  int read(char[] cbuf) 将字符读入数组。
 *  abstract  void close() 关闭该流并释放与之关联的所有资源。
 *
 *  java.io.Reader
 *       继承者 java.io.InputStreamReader
 *           继承者 java.io.FileReader
 *    FileReader:文件字符输入流
 *      把硬盘中的数据以字符的形式读取到内存中
 *
 *  构造方法
 *  FileReader(String fileName)  在给定从中读取数据的文件名的情况下创建一个新 FileReader。
 *  FileReader(File file)  在给定从中读取数据的 File 的情况下创建一个新 FileReader。
 *  参数：读取文件的数据源
 *      String fileName：文件的路径
 *      File file：一个文件
 *   构造方法作用：
 *      1.创建一个FileReader对象
 *      2.会把创建一个FileReader对象指向要读取的文件
 *
 * FileReader字符输入流的使用步骤：
 *      1.创建一个FileReader对象，构造方法中绑定要读取的数据
 *      2.使用一个FileReader对象中的方法read读取文件
 *      3.释放资源  close
 *
 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:\\LJF\\c.txt");
//        int len = 0;
//        while ((len = fr.read()) != -1) {
//            System.out.println((char)len);
//        }

        //一次读取多个字符
        char[] chars = new char[1024];//存储读取到的多个字符
        int len = 0;//记录读取到的每个有效字符个数
        while ((len = fr.read(chars)) != -1) {
            /*
                String类的构造方法
                    String(char[] value) 把字符数组转换为字符串
                    String(char[] value, int offset, int count) 把字符数组的一部分转换为字符串
             */
            System.out.println(new String(chars,0,len));
        }

        fr.close();
    }
}
