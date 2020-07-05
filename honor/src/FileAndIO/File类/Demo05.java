package FileAndIO.File类;

import java.io.File;

/*
String[] list()     返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
 File[] listFiles()      返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
 */
public class Demo05 {
    public static void main(String[] args) {
        File file = new File("g:\\");
        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        System.out.println("=========================");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
