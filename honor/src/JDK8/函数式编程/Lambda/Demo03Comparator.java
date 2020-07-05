package JDK8.函数式编程.Lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式。当需要通过一
 * 个方法来获取一个 java.util.Comparator 接口类型的对象作为排序器时,就可以调该方法获取。
 */
public class Demo03Comparator {
    //定义一个方法，方法的返回值使用函数式接口Comparator
    public static Comparator<String> getComparator() {
        //方法的返回值是函数式接口，那么可以返回这个接口的匿名内部类
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                //按照字符串降序排序
//                return o2.length() - o1.length();
//            }
//        };

        //方法的返回值是函数式接口，可以使用Lambda表达式
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static void main(String[] args) {
        String[] arr = {"aaa","BFBBB","cSDSA"};
        //输出排序前的数组
        System.out.println("排序前：" + Arrays.toString(arr));

        Arrays.sort(arr,getComparator());
        //输出排序后的数组
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
