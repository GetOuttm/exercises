package FileAndIO.File类;

import java.io.File;
import java.io.IOException;

/*
boolean createNewFile()     当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
        文件存在则不会创建返回false   文件不存在则创建返回true   只能创建文件不能创建文件夹  路径必须存在
boolean delete()    删除此抽象路径名表示的文件或目录。
boolean mkdir()     创建此抽象路径名指定的目录。
boolean mkdirs()    创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        File file = new File("g:\\");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);


        boolean mkdir = file.mkdir();
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdir);
        System.out.println(mkdirs);
    }
}
