package CollectionDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/***
 * Collection  所有集合的接口，规定了所有集合的具体行为
 * List 1.有序(存入取出顺序相同)  2.可重复   3.有索引
 *      Vector线程安全      ArrayList线程不安全  LinkedList线程不安全
 * Set  1.无序  2.不可重复
 *      TreeSet线程不安全    LinkedSet线程不安全   HashSet线程不安全
 */
public class Demo {
    public static void main(String[] args) {
        Collection<String> collection  = new ArrayList<>();
        collection.add("我");
        collection.add("你");
        collection.add("李四");
        collection.add("张三");
        System.out.println(collection);

        System.out.println(collection.size());

        collection.remove("我");
        System.out.println(collection);

        //判断是否包含此元素
        System.out.println(collection.contains("礼金"));

        //判断集合是否为空
        System.out.println(collection.isEmpty());

        Object[] objects = collection.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        System.out.println("===============================");
        //推荐
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Iterator<String> iterator2 = collection.iterator();iterator2.hasNext();) {
            System.out.println(iterator2.next());
        }


        //清空集合
        collection.clear();
        System.out.println(collection);

    }
}
