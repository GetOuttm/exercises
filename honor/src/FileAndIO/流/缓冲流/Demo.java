package FileAndIO.流.缓冲流;

import java.io.*;
import java.util.HashMap;

/**
 * 文本排序
 * 案例分析：
 *  1.创建一个HashMap集合对象：存储每行文本的序号(1,2,3...);value存储每行的文本
 *  2.创建字符缓冲输入流，构造方法中绑定字符输入流
 *  3.创建字符缓冲输出流，构造方法中绑定字符输出流
 *  4.使用字符缓冲输入流中的方法readLine，逐行读取文本
 *  5.对读取到的文本进行切割，获取行中的序号和文本内容
 *  6.把切割好的序号和文本内容存储到HashMap集合中(key序号是有序的，会自动排序)
 *  7.遍历HashMap集合。获取每一个键值对，
 *  8.把每一个键值对拼接成文本行
 *  9.把拼接好的文本行使用字符缓冲输出流中的方法write，写入到文件
 *  10.释放资源
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("F:\\LJF\\qwe.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\LJF\\io.txt"));

        String len;
        while ((len = br.readLine()) != null) {
            String[] arr = len.split("\\.");
            hashMap.put(arr[0],arr[1]);
        }

        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            len = key + "." + value;
            bw.write(len);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
