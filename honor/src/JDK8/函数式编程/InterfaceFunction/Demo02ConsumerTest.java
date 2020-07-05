package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Consumer;

/**
 * 练习：格式化打印信息
 * 题目
 * 下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。要求将打印姓
 * 名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个 Consumer 接口的Lambda实
 * 例，将两个 Consumer 接口按照顺序“拼接”到一起。
 */
public class Demo02ConsumerTest {
    public static void getConsumer(String[] arr, Consumer<String> one, Consumer<String> two) {
        for (String a : arr) {
            one.andThen(two).accept(a);
        }
    }

    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        getConsumer(array,(arr) -> {
            String name = arr.split(",")[0];
            System.out.print("姓名:" + name);
            },(arr) -> {
            String age = arr.split(",")[1];
            System.out.println("。性别:" + age);
        });
    }

}
