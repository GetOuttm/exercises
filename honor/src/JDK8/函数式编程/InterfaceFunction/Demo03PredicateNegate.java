package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Predicate;

/**
 * “非”（取反）
 *   需求：判断一个字符串有两个判断条件
 *      1.字符串的长度是大于5  返回false
 *      2.字符串的长度是小于5   返回true
 *    使用!运算符连接两个条件
 *
 *    default Predicate<T> negate() {
 *      return (t) ‐> !test(t);
 *    }
 */
public class Demo03PredicateNegate {
    public static boolean getAnd(String arr, Predicate<String> one) {
        //return !one.test(arr);
        return one.negate().test(arr);
    }

    public static void main(String[] args) {
        boolean b = getAnd("ansj", arr -> {
            return arr.length() > 5;
        });
        System.out.println(b);
    }
}
