package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Function;

/**
 * 练习：自定义函数模型拼接
 * 题目
 * 请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * String str = "赵丽颖,20";
 * 1. 将字符串截取数字年龄部分，得到字符串；
 * 2. 将上一步的字符串转换成为int类型的数字；
 * 3. 将上一步的int数字累加100，得到结果int数字。
 */
public class Demo04Function {
    public static int test(String str, Function<String,String> one,Function<String,Integer> two,
                            Function<Integer,Integer> three) {
        return one.andThen(two).andThen(three).apply(str);
    }

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        int test = test(str, s -> s.split(",")[1],
                s -> Integer.parseInt(s),
                i -> i + 100);
        System.out.println(test);
    }

}
