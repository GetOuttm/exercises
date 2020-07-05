package FileAndIO.流.转换流;

import java.io.*;

/**
 * 转换文件编码
 *  将GBK编码的文本文件，转换为UTF-8编码的文本文件。
 *
 *  分析":
 *      1.创建InputStreamReader对象，构造方法中传递字节输入流和编码表名称GBK
 *      2.创建OutputStreamWriter对象，构造方法中传递字节输出流和编码表名称UTF-8
 *      3.使用InputStreamReader对象中的方法read读取文件
 *      4.使用OutputStreamWriter对象中的方法writer把读取到的数据写入到文件中
 *      5.释放资源
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\LJF\\2.txt"),
                "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\LJF\\3.txt"),
                "utf-8");

        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
        }

        isr.close();
        osw.close();
    }
}
