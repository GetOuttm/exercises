package FileAndIO.File类;

import java.io.File;

/**
 * 路径：
 *  相对路径：一个简化的路径
 *      相对指的是相对于当前项目的根目录(D:\\data\\logs)
 *      如果使用当前项目的根目录，可以简化为logs
 *  绝对路径：一个完整的路径
 *      以盘符开始的路径   C:\\A.txt
 *
 *
 * 注意：路径不区分大小写
 *      路径的文件名称分隔符  windows使用的是反斜杠\，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 */
public class Demo01 {
    public static void main(String[] args) {

        show01();
        show02("c:\\","a.txt");
        show03();
    }

     /*
    File(File parent, String child)     根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
    参数：把路径分为两部分
        String parent  父路径
        String child   子路径
    好处：
        父路径和子路径，可以单独书写，用起来非常灵活；父路径和子路径都可以变化
        父路径是File类型，可以使用File的方法对路径进行一些操作，在使用路径创建对象
     */
    private static void show03() {
        File file = new File("c:\\");
        File file1 = new File(file,"hello.java");
        System.out.println(file1);
    }

    /*
    File(String parent, String child)   根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
     参数：把路径分为两部分
        String parent  父路径
        String child   子路径
     好处：
        父路径和子路径，可以单独书写，用起来非常灵活；父路径和子路径都可以变化
     */
    private static void show02(String parent, String child) {
        File file = new File(parent,child);
        System.out.println(file);
    }

    /*
    File(String pathname)   通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
    参数：String pathname字符串是路径名称
        路径可以是文件结尾，也可以是文件夹结尾
        路径可以是相对路径，也可以是绝对路径
        路径可以存在也可以不存在
        创建File对象只是把字符串路径封装成File对象，不考虑路径的真假性
     */
    private static void show01() {
        File file = new File("F:\\idea1.txt");
        System.out.println(file);//重写了Object的toString方法

        File file2 = new File("F:\\idea.txt");
        System.out.println(file2);

        File file3 = new File("idea.txt");
        System.out.println(file3);


    }
}
