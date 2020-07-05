package JDK8.Stream流.获取流的方式;

import java.util.stream.Stream;

/**
 * Stream流中常用方法limit
 * 取用前几个：limit
 * limit 方法可以对流进行截取，只取用前n个。方法签名：
 *  Stream<T> limit(long maxSize);
 *参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作。
 *
 * limit是延迟方法，只是对流中的元素截取，返回的是一个新的流，可以继续调用Stream流中的其他方法
 */
public class Demo06Limit {
    public static void main(String[] args) {
        String[] arr = {"张三丰", "张翠山", "张三", "李四", "王五"};
        Stream<String> stream = Stream.of(arr);
        //只要前三个
        Stream<String> limit = stream.limit(3);
        limit.forEach(name -> System.out.println(name));
    }
}
