package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Predicate;

/**
 * 逻辑表达式：可以连接多个判断的条件
 * &&:与运算符，有false则false
 * ||:或运算符，有true则true
 * !：非取反
 *
 * 需求：判断一个字符串有两个判断条件
 *  1.判断字符串的长度是否大于5
 *  2.判断字符串中是否包含a
 * 两个条件必须同时满足，我们就可以使用&&运算符连接两个条件
 *
 * Predicate接口中有一个方法and，表示并且关系，也可以用于连接两个判断条件
 * default Predicate<T> and(Predicate<? super T> other) {
 *      Objects.requireNonNull(other);
 *      return (t) ‐> test(t) && other.test(t);
 * }
 * 方法内部的两个判断条件，也可以使用&&运算符连接起来
 */
public class Demo03PredicateAnd {
    public static boolean getAnd(String arr, Predicate<String> one,Predicate<String> two) {
//        return one.test(arr) && two.test(arr);
        return one.and(two).test(arr);
    }

    public static void main(String[] args) {
        boolean b = getAnd("anshsj", arr -> {
            return arr.length() > 5;
        }, arr -> {
            return arr.contains("a");
        });
        System.out.println(b);
    }
}
