package JDK8.函数式编程.InterfaceFunction;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合
 * ArrayList 中，需要同时满足两个条件：
 * 1. 必须为女生；
 * 2. 姓名为4个字。
 * String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
 *
 * 分析：
 *  1.两个判断条件。所以需要使用两个Predicate接口，对条件进行判断
 *  2.必须同时满足两个条件，可以使用and连接两个判断条件
 */
public class Demo03PredicateDemo {
    public static ArrayList<String> test(String[] array, Predicate<String> one,
                                         Predicate<String> two) {
        ArrayList<String> list = new ArrayList<>();
        for (String arr : array) {
            boolean b = one.and(two).test(arr);
            if (b) {
                list.add(arr);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        ArrayList<String> list = test(array, arr -> arr.split(",")[0].length() == 4
                , arr -> arr.split(",")[1].equals("女"));
        for (String s : list) {
            System.out.println(s);
        }
    }
}
