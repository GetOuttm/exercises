package JDK8.Stream流.获取流的方式;

import java.util.*;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T>是java8新加入的常用流接口。(这并不是一个函数式接口)
 * 获取一个流非常简单，有以下常用的方法：
 *      所有的 Collection 集合都可以通过 stream 默认方法获取流；
 *          default Stream<E> stream()
 *      Stream 接口的静态方法 of 可以获取数组对应的流。
 *          static <T> Stream<T> of(T... values)
 *          参数是可变参数，我们可以传递一个数组
 */
public class Demo01GetStream {
    public static void main(String[] args) {
        //把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        Map<String,String> map = new HashMap<>();
        //获取键，存储到set集合
        Set<String> keySet = map.keySet();
        Stream<String> stream2 = keySet.stream();
        //获取值，存储到Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream3 = values.stream();
        //获取键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entries.stream();


        //把数组转换为Stream流
        Stream<Integer> stream5 = Stream.of(1,2,3,4,5,6);
        //可变参数可传递数组
        Integer[] arr = {12,3,5,6,7,2};
        Stream<Integer> stream6 = Stream.of(arr);

        String[] arr1 = {"a","bb","ccc"};
        Stream<String> stream7 = Stream.of(arr1);
    }
}
