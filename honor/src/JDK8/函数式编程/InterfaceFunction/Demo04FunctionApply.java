package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Function;

/**
 * java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，
 * 后者称为后置条件。
 * Function 接口中最主要的抽象方法为： R apply(T t) ，根据类型T的参数获取类型R的结果使用的场景例如：
 *  将 String 类型转换为 Integer 类型。
 */
public class Demo04FunctionApply {
    public static void getApply(String s,Function<String, Integer> function) {
//        Integer apply = function.apply(s);
        int apply = function.apply(s);//自动拆箱  Integer > int
        System.out.println(apply);
    }

    public static void main(String[] args) {
        getApply("123456",s -> Integer.parseInt(s));
    }
}
