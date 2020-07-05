package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Function;

/**
 * Function 接口中有一个默认的 andThen 方法，用来进行组合操作
 * 需求：把String类型的字符串转换为Integer，把转换之后的数据加10
 *      把增加之后的数据转换为String类型
 *
 * 该方法同样用于“先做什么，再做什么”的场景，和 Consumer 中的 andThen 差不多：
 * default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
 *      Objects.requireNonNull(after);
 *      return (T t) ‐> after.apply(apply(t));
 * }
 */
public class Demo04FunctionAndThen {
    public static void getAndThen(String s,Function<String,Integer> one,
                                  Function<Integer,String> two) {
        String apply = one.andThen(two).apply(s);
        System.out.println(apply);
    }

    public static void main(String[] args) {
        String arr = "7894561";
        getAndThen(arr,s -> Integer.parseInt(s) + 10,i -> i + "");
    }
}
