package FileAndIO.序列化流;

import java.io.*;
import java.util.ArrayList;

/**
 * 练习：序列化集合
 *  当我们想在文件中保存多个对象的时候
 *  可以把多个对象存储到集合中
 *  对ijhe进行序列化和反序列化
 *
 *  分析：
 *      1.定义一个存储Person对象的ArrayList集合
 *      2.往ArrayList中存储Person对象
 *      3.创建一个序列化流ObjectOutputStream对象
 *      4.使用ObjectOutputStream对象中的writeObject对集合进行序列化
 *      5.创建一个反序列化ObjectInputStream对象
 *      6.使用ObjectInputStream对象中的readObject读取文件中保存的集合
 *      7.把Object类型的集合转换为ArrayList类型
 *      8.遍历ArrayList集合
 *      9.释放资源
 */
public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("张三",18));
        arrayList.add(new Person("王五",19));
        arrayList.add(new Person("赵六",20));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\LJF\\person1" +
                ".txt"));
        oos.writeObject(arrayList);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\LJF\\person1.txt"));
        Object o = ois.readObject();

        ArrayList<Person> arrayList1 = (ArrayList<Person>)o;

        for (Person person : arrayList1) {
            System.out.println(person.getName() + person.getAge());
        }

        oos.close();
        ois.close();
    }
}
