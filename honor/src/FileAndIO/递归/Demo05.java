package FileAndIO.递归;

import java.io.File;

/**
 * 文件搜索
 * 搜索 D:\aaa 目录中的 .java 文件。
 * 分析：
 * 1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
 * 2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
 */
public class Demo05 {
    public static void main(String[] args) {
        File file = new File("D:\\app");
        getAllFiles(file);
    }

    /*
    定义一个方法，参数传递File类的目录
    方法中对目录进行遍历
     */
    public static void getAllFiles(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFiles(file);
            } else {
                /**
                 * 只要.java的文件
                 * 1.把file转换成字符串对象
                 */
                String path = file.getPath().toLowerCase();

                //2.调用String类中的方法endsWith判断是否是.java文件
                boolean b = path.endsWith(".java");

                //3.如果是则输出
                if (b) {
                    System.out.println(path);
                }

//                if (file.toString().toLowerCase().endsWith(".java")) {
//                    System.out.println(file);
//                }
            }
        }
    }
}
