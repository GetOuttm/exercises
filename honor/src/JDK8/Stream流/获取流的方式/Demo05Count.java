package JDK8.Stream流.获取流的方式;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Stream流中常用方法count:用于统计Stream流中元素得个数
 * 统计个数：count
 * 正如旧集合 Collection 当中的 size 方法一样，流提供 count 方法来数一数其中的元素个数：
 * long count();
 *count方法是一个终结方法，返回一个lang类型的整数，所以不能再继续调用Stream流中的其他方法
 */
public class Demo05Count {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(56);
        list.add(45);
        list.add(54);
        list.add(23);
        list.add(12);

        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }
}
