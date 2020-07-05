package JDK8.Stream流.获取流的方式;

import java.util.stream.Stream;

/**
 * Stream流中常用方法filter:用于对Stream流中的数据进行过滤
 * Stream<T> filter(Predicate<? super T> predicate);
 * 该接口接收一个 Predicate 函数式接口参数（可以是一个Lambda或方法引用）作为筛选条件。
 * java.util.stream.Predicate 函数式接口，其中唯一的抽象方法为：
 *      boolean test(T t);
 */
public class Demo03Filter {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张三", "李四", "王五");

        Stream<String> stream1 = stream.filter(name -> name.startsWith("张"));

        stream1.forEach(name -> System.out.println(name));

        /**
         * Stream流是管道流，只能被消费(使用)一次。
         * 第一个Stream流调用完毕方法，数据就会流转到下一个Stream流觞，
         * 第一个Stream流使用完毕关闭，所以第一个Stream流就不能在使用了
         *
         * java.lang.IllegalStateException: stream has already been operated upon or closed
         */
        stream.forEach(name -> System.out.println(name));
    }
}
