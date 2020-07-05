package FileAndIO.递归;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.io.File;

/*
递归打印多级目录
分析：多级目录的打印，就是当目录的嵌套。遍历之前，无从知道到底有多少级目录，所以我们还是要使用递归实
现。
 */
public class Demo04 {
    public static void main(String[] args) {
        File file = new File("D:\\a");
        getAllFiles(file);
    }

    /*
    定义一个方法，参数传递File类的目录
    方法中对目录进行遍历
     */
    public static void getAllFiles(File dir) {
        System.out.println(dir);

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFiles(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
