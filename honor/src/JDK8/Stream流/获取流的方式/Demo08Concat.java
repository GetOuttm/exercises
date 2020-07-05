package JDK8.Stream流.获取流的方式;

import java.util.stream.Stream;

/**
 * Stream流中常用方法concat:用于把流组合到一起
 * 组合：concat
 * 如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat ：
 * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 * 备注：这是一个静态方法，与 java.lang.String 当中的 concat 方法是不同的。
 */
public class Demo08Concat {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张三", "李四", "王五");
        Stream<String> stream1 = Stream.of("1", "2", "3", "4", "5");

        Stream<String> concat = Stream.concat(stream, stream1);
        concat.forEach(s -> System.out.println(s));
    }
}
