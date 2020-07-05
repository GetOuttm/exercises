package SetDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * java.util.Set接口 extends Collection接口
 * 特点：
 *  1.不允许存储重复元素
 *  2.没有索引，故无序，不能使用简单的for循环遍历
 *
 *  java.util.HashSet接口 implement Set接口
 *  特点：
 *      1.不允许存储重复的元素
 *      2.没有索引，也不能使用for循环遍历
 *      3.一个无序集合，存储和取出顺序可能不一致
 *      4.底层是一个hash结构(查询速度快)
 */
public class Demo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //增强for
        for (Integer i : set) {
            System.out.println(i);
        }


    }
}
