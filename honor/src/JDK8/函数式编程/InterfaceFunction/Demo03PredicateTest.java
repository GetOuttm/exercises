package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Predicate;

/**
 * Predicate<T> 表示一个参数的谓词（布尔值函数）。
 * java.util.function.Predicate<T> 接口。
 * 作用：对某种类型的数据进行判断从而得到一个boolean值结果。
 * Predicate 接口中包含一个抽象方法： boolean test(T t) 用于条件判断的场景
 */
public class Demo03PredicateTest {
    public static boolean getTest(String arr, Predicate<String> one) {
        return one.test(arr);
    }

    public static void main(String[] args) {
        boolean test = getTest("哇哈哈哈哈哈", str -> {
            return str.length() > 5;
        });
        System.out.println(test);
    }
}
