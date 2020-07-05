package FileAndIO.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * java.util.Dictionary<K,V>
 *       继承者 java.util.Hashtable<Object,Object>
 *           继承者 java.util.Properties
 *      java.util.Properties extends Hashtable<k,y> implements Map<k,v>
 * Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。
 *      Properties集合是唯一和io流相结合的集合
 *          可以使用Properties中的方法store，把集合中的临时数据持久化写入到硬盘中存储
 *          可以使用Properties中的方法load，把硬盘中存储的文件(键值对)，读取到集合中使用
 *
 * 属性列表中每个键及其对应值都是一个字符串。
 *      Properties集合是一个双列集合，key和value默认都是字符串
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //show01();
        
        //show02();

        show03();
    }

    /**
     * 可以使用Properties中的方法load，把硬盘中存储的文件(键值对)，读取到集合中使用
     *      void load(InputStream inStream)  从输入流中读取属性列表（键和元素对）。
     *      void load(Reader reader)  按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
     *         参数：
     *              InputStream inStream：字节输入流，不能读取含有中文的键值对
     *              Reader reader：字符输入流，可以读取含有中文的键值对
     */
    private static void show03() throws IOException {
        //1.创建Properties集合对象
        //2.使用Properties集合对象的方法load读取保存键值对的文件
        //3.遍历Properties集合
        /*
        注意事项：
            1.存储键值对的文件中，键与值默认的连接符号可以使用=，空格(其他符号)
            2.存储键值对的文件中，可以使用#注释，注释的键值对不会被读取
            3.存储键值对的文件中，键与值默认都是字符串，不用在加""
         */
        Properties properties = new Properties();
        //properties.load(new FileReader("f:\\LJF\\properties.txt"));
        //字节流
        properties.load(new FileInputStream("f:\\LJF\\properties.txt"));
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            String value = properties.getProperty(key);
            System.out.println(key + ":" + value);
        }

    }

    /**
     * 可以使用Properties中的方法store，把集合中的临时数据持久化写入到硬盘中存储
     *  void store(OutputStream out, String comments)  以适合使用 load(InputStream) 方法加载到 Properties
     *          表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。
     *  void store(Writer writer, String comments)  以适合使用 load(Reader) 方法的格式，将此 Properties
     *          表中的属性列表（键和元素对）写入输出字符。
     *   参数：
     *      OutputStream out：字节输出流，不能写中文
     *      Writer writer：字符输出流，可以写中文
     *      String comments：注释,用来解释说明保存的文件是干什么的
     *          不能使用中文，会产生乱码，默认是Unicode编码，一般使用""空字符串
     */
    private static void show02() throws IOException {
        //1.创建Properties集合对象，添加一些数据
        Properties properties = new Properties();
        properties.setProperty("张三","188");
        properties.setProperty("李四","177");
        properties.setProperty("王五","166");

        //2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        //FileWriter fw = new FileWriter("f:\\LJF\\properties.txt");

        //3.使用Properties集合中的方法store，把集合中的数据持久化写入到硬盘中
        //properties.store(fw,"save date");

        //4.释放资源
        //fw.close();


        //字节流
        //匿名对象使用完毕自己关闭
        properties.store(new FileOutputStream("f:\\LJF\\properties1.txt"),"");
    }

    /**
     * 使用Properties集合存储数据，遍历取出Properties集合中的数据
     * Properties集合是一个双列集合，key和value默认都是字符串
     * Properties集合有一些操作字符串的特有方法：
     *  Object setProperty(String key, String value)  调用 Hashtable 的方法 put。
     *  String getProperty(String key)  通过key找到value，相当于Map集合中的get(key)方法
     *  Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串，
     *      此方法相当于Map集合中的keySet方法
     */
    private static void show01() {
        //1.创建一个Properties集合对象
        Properties properties = new Properties();

        //2.使用setProperty往集合中添加数据
        properties.setProperty("张三","188");
        properties.setProperty("李四","177");
        properties.setProperty("王五","166");
//        properties.put(1,2);

        //3.使用stringPropertyNames把properties集合中的数据取出存储到一个set集合中
        Set<String> set = properties.stringPropertyNames();

        for (String key : set) {
            //4.使用getProperty通过key获取value
            String value = properties.getProperty(key);
            System.out.println(key + ":" + value);
        }
    }
}
