package FileAndIO.过滤器;

import java.io.File;
import java.io.FileFilter;

/*
创建过滤器FileFilter的实现类，重写过滤方法accept，定义过滤规则
 */
public class FileFilterIml implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        return pathname.toString().toLowerCase().endsWith(".java");
    }
}
