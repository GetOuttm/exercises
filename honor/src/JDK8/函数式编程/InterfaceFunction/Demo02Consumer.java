package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Consumer;

/**
 * Consumer<T> 表示接受单个输入参数并且不返回结果的操作。
 * java.util.function.Consumer<T> 接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据，
 * 其数据类型由泛型决定。
 * Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据。基本使用如：
 * Consumer接口是一个消费型接口，泛型是什么类型，就可以使用accept方法消费什么类型的数据
 * 至于消费什么类型的大数据需要自定义
 */
public class Demo02Consumer {
    /*
    定义一个方法，方法的参数传递一个字符串的姓名，方法的参数传递Consumer接口，泛型使用字符串，可以使用Consumer
    接口消费字符串的姓名
     */
    public static void method(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void main(String[] args) {
        method("李锦峰", (name) -> {
            System.out.println(name);

            //把字符串进行反转
            System.out.println(new StringBuilder(name).reverse().toString());
        });
    }
}
