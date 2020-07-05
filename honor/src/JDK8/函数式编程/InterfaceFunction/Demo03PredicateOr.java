package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Predicate;

/**
 * 需求：判断一个字符串有两个判断条件
 *    1.判断字符串的长度是否大于5
 *    2.判断字符串中是否包含a
 *  一个条件满足即可，我们就可以使用||运算符连接两个条件
 *
 *  default Predicate<T> or(Predicate<? super T> other) {
 *      Objects.requireNonNull(other);
 *      return (t) ‐> test(t) || other.test(t);
 * }
 */
public class Demo03PredicateOr {
    public static boolean getAnd(String arr, Predicate<String> one, Predicate<String> two) {
//        return one.test(arr) || two.test(arr);
        return one.or(two).test(arr);
    }

    public static void main(String[] args) {
        boolean b = getAnd("ansj", arr -> {
            return arr.length() > 5;
        }, arr -> {
            return arr.contains("a");
        });
        System.out.println(b);
    }
}
