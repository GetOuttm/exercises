package FileAndIO.File类;

import java.io.File;

/*
String getAbsolutePath()    返回此抽象路径名的绝对路径名字符串。  无论绝对路径还是相对路径都可以
String getPath()     将此抽象路径名转换为一个路径名字符串。
String getName()    返回由此抽象路径名表示的文件或目录的名称。   结尾部分
 long length()  返回由此抽象路径名表示的文件的长度。
 */
public class Demo02 {

    public static void main(String[] args) {
        File file = new File("G:\\java高级课程\\阶段1 语言基础+高级\\1-3-Java语言高级\\06-File类与IO流\\01 File类");

        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        String name = file.getName();
        System.out.println(name);

        String path = file.getPath();
        System.out.println(path);

        long length = file.length();//不存在返回0
        System.out.println(length);
    }
}
