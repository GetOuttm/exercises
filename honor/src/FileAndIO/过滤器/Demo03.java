package FileAndIO.过滤器;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * 文件搜索
 * 搜索 D:\aaa 目录中的 .java 文件。
 * 分析：
 * 1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
 * 2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
 *
 * 使用过滤器来实现
 * 在File类中有两个和listFiles重载的方法，方法的参数传递的就是过滤器
 *   File[] listFiles(FilenameFilter filter)
 *           返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 *          java.io.FilenameFilter接口：实现此接口的类实例可用于过滤器文件名
 *          作用：过滤文件名称
 *          抽象方法：用来过滤文件的方法
 *           boolean accept(File dir, String name)
 *           测试指定文件是否应该包含在某一文件列表中。
 *           参数：File dir：构造方法中传递的被遍历的目录
 *                String name：使用ListFiles方法遍历目录，得到的每一个文件/文件夹名称
 *
 *   File[] listFiles(FileFilter filter)
 *           返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 *           java.io.FileFilter接口：用于抽象路径名(File对象)的过滤器。
 *           作用：用来过滤文件(File对象)
 *           抽象方法：用来过滤文件的方法
 *            boolean accept(File pathname)
 *           测试指定抽象路径名是否应该包含在某个路径名列表中。
 *           参数：
 *              File pathname：使用ListFiles方法遍历目录，得到的每一个文件对象
 *
 *  注意：
 *     两个过滤器接口没有实现类，需要自己写实现类，重写过滤的方法accept,在方法中定义过滤的规则
 */
public class Demo03 {
    public static void main(String[] args) {
        File file = new File("D:\\app");
        getAllFiles(file);
    }

    /*
    定义一个方法，参数传递File类的目录
    方法中对目录进行遍历
     */
    public static void getAllFiles(File dir) {
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFiles(file);
            } else {
                System.out.println(file);
//                if (file.toString().toLowerCase().endsWith(".java")) {
//                    System.out.println(file);
//                }
            }
        }
    }
}
