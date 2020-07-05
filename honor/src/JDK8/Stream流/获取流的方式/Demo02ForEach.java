package JDK8.Stream流.获取流的方式;

import java.util.stream.Stream;

/**
 * Stream流中常用方法forEach
 * void forEach(Consumer<? super T> action);
 * 该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理。
 *
 * Consumer是一个消费型函数式接口。可以传递Lambda表达式
 * 简单记：
 *  forEach方法用来遍历流的数据
 *  是一个终结方法，遍历之后就不能继续调用Stream流中的方法
 */
public class Demo02ForEach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
        stream.forEach(name -> System.out.println(name));
    }
}
