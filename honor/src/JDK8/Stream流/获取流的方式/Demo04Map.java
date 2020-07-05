package JDK8.Stream流.获取流的方式;

import java.util.stream.Stream;

/**
 * Stream流中常用方法map
 * 如果需要将流中的元素映射到另一个流中，可以使用 map 方法。方法签名：
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 * 该接口需要一个 Function 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
 * java.util.stream.Function 函数式接口，其中唯一的抽象方法为：
 *      R apply(T t);
 *      这可以将一种T类型转换成为R类型，而这种转换的动作，就称为“映射”。
 */
public class Demo04Map {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");

        Stream<Integer> stream1 = stream.map(s -> Integer.parseInt(s));

        stream1.forEach(i -> System.out.println(i));

    }
}
