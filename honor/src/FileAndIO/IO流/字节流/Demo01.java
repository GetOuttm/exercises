package FileAndIO.IO流.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
读写
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\a.jpg");
        FileOutputStream fos = new FileOutputStream("F:\\LJF\\a.jpg");
        long l = System.currentTimeMillis();
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }

//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = fis.read(bytes)) != -1) {
//            fos.write(bytes,0,len);
//        }

        fis.close();
        fos.close();
        long e = System.currentTimeMillis();

        System.out.println("复制文件的时间" + (e - l) + "m");
    }
}
