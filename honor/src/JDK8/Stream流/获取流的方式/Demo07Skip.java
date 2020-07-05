package JDK8.Stream流.获取流的方式;

import java.util.stream.Stream;

/**
 * Stream流中常用方法skip
 * 跳过前几个：skip
 * 如果希望跳过前几个元素，可以使用 skip 方法获取一个截取之后的新流：
 * Stream<T> skip(long n);
 * 如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
 */
public class Demo07Skip {
    public static void main(String[] args) {
        String[] arr = {"张三丰", "张翠山", "张三", "李四", "王五"};
        Stream<String> stream = Stream.of(arr);

        //跳过前2个
        Stream<String> skip = stream.skip(2);
        skip.forEach(name -> System.out.println(name));
    }
}
