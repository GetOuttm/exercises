package ListDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java.util.list的接口 extends Collection接口
 *
 * list接口的特点：
 *  1.有序集合，存储和取出的元素顺序是一致的
 *  2.有索引，包含一些带索引的方法
 *  3.允许存储重复的元素
 *
 *  list接口中带索引的方法
 *   void add(int index, E element)
 *           在列表的指定位置插入指定元素（可选操作）。
 *   E get(int index)
 *           返回列表中指定位置的元素。
 *   E remove(int index)
 *           移除列表中指定位置的元素（可选操作）。
 *   E set(int index, E element)
 *           用指定元素替换列表中指定位置的元素（可选操作）。
 *
 * 注意：操作索引的时候，一定要防止索引越界异常
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("q");
        list.add("a");
        list.add("z");
        System.out.println(list);

        //index是几就放到哪个位置
        list.add(2,"巴拉拉");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        System.out.println(list.get(1));

        list.set(1,"三天0");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
