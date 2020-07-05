package FileAndIO.File类;

import java.io.File;

/**
 * java.io.File类
 * 文件和目录路径名的抽象表示形式
 * java把电脑中的文件和文件夹(目录)封装了一个File类，我们可以使用File类对文件或文件夹进行操作
 *      创建文件/文件夹
 *      删除文件/文件夹
 *      获取文件/文件夹
 *      判断文件/文件夹是否存在
 *      对文件夹进行遍历
 *      获取文件的大小
 *File类是一个与系统无关的类，任何的操作系统都可以使用这个类中的方法
 *
 * 重点：三个单词
 *      File: 文件
 *      directory：文件夹/目录
 *      path：路径
 */
public class Demo {
    public static void main(String[] args) {
        /*
        static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
        static char pathSeparatorChar   与系统有关的路径分隔符。
        static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
        static char separatorChar   与系统有关的默认名称分隔符。


        操作路径：路径不能写死
         */
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//路径分隔符  windows是分号。linux是冒号

        char pathSeparatorChar = File.pathSeparatorChar;
        System.out.println(pathSeparatorChar);//

        String separator = File.separator;
        System.out.println(separator);//文件名称分隔符  windows是\  linux是/

        char separatorChar = File.separatorChar;
        System.out.println(separatorChar);
    }
}
