package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Supplier;

/**
 * Supplier<T> 代表结果供应商。
 * 常用的函数式接口
 * java.util.function.Supplier<T> 接口仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。
 * Supplier<T>接口也称生产型接口，指定接口的泛型是什么类型，那么接口的get方法就会产生什么类型的数据
 */
public class Demo01Supplier {
    //定义一个方法，参数为Supplier<T>接口，泛型为String，get方法就会返回String类型的数据
    public static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String s = getString(() -> "生产一个字符串");
        System.out.println(s);
    }
}
