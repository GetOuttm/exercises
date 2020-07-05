package FileAndIO.IO流.字符流.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * flush和close方法的区别：
 *  -flush：刷新缓冲区，流对象可以继续使用。
 *  -close：先刷新缓冲区，然后通知系统释放资源，流对象不可以在被使用了。
 */
public class Demo02FlushAndClose {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\LJF\\dd.txt");
        fw.write(97);

        fw.flush();
        //刷新之后，流可以继续使用
        fw.write(98);

        fw.close();
        /**
         * Exception in thread "main" java.io.IOException: Stream closed
         * close方法之后流已经关闭了，已经从内存中消失了，流就不能再使用了
         */
//        fw.write(99);
    }
}
