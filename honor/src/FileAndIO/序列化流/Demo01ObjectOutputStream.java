package FileAndIO.序列化流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * java.io.OutputStream
 *       继承者 java.io.ObjectOutputStream
 *  ObjectOutputStream:对象的序列化流
 *      作用：把对象以流的方式写入到文件中保存
 *  构造方法：
 *      ObjectOutputStream(OutputStream out)  创建写入指定 OutputStream 的 ObjectOutputStream。
 *      参数：
 *          OutputStream out：字节输出流
 * 特有的成员方法：
 *  void writeObject(Object obj)  将指定的对象写入 ObjectOutputStream。
 *
 *  使用步骤：
 *      1.创建ObjectOutputStream对象，构造方法中传递字节输出流
 *      2.使用ObjectOutputStream对象中的方法writeObject把对象写入到文件中
 *      3.释放资源
 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:\\LJF\\person" +
                ".txt"));
        oos.writeObject(new Person("李四",19));
        oos.close();
    }
}
