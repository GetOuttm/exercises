package FileAndIO.File类;

import java.io.File;

/*
boolean exists()    测试此抽象路径名表示的文件或目录是否存在。

路径为空则的都返回false
boolean isDirectory()   测试此抽象路径名表示的文件是否是一个目录。
 boolean isFile()   测试此抽象路径名表示的文件是否是一个标准文件。

 */
public class Demo03 {
    public static void main(String[] args) {
        File file = new File("G:\\java高级课程\\阶段1 语言基础+高级\\1-3-Java语言高级\\06-File类与IO流\\01 File类");
        boolean exists = file.exists();
        System.out.println(exists);

        boolean directory = file.isDirectory();
        System.out.println(directory);

        boolean file1 = file.isFile();
        System.out.println(file1);
    }
}
