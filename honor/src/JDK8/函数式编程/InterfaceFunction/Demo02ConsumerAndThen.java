package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Consumer;

/**
 * Consumer默认方法：andThen
 * 作用：需要两个Consumer接口，可以把两个Consumer接口组合到一起，在对数据进行消费
 *
 */
public class Demo02ConsumerAndThen {
    public static void getAndThen(String s, Consumer<String> one, Consumer<String> two) {
        //one.accept(s);
        //two.accept(s);
        //使用andThen方法，把两个Consumer接口连接在一起，并消费
        one.andThen(two).accept(s);//one连接two，先执行one在执行two
    }

    public static void main(String[] args) {
        getAndThen("张三李四王五",(s) -> {
            System.out.println(s);
        },(s) -> {
            System.out.println(new StringBuilder(s).reverse().toString());
        });
    }

}
