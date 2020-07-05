package FileAndIO.流.缓冲流.字节;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\a.MP4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\LJF\\a.MP4"));
//        int len = 0;
//        while ((len = bis.read()) != -1) {
//            bos.write(len);
//        }
        //复制文件的时间109m
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes,0,len);
        }
        //复制文件的时间10m

        bis.close();
        bos.close();

        long e = System.currentTimeMillis();

        System.out.println("复制文件的时间" + (e - l) + "m");
    }
}
