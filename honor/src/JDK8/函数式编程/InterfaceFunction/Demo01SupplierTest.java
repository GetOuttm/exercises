package JDK8.函数式编程.InterfaceFunction;

import java.util.function.Supplier;

/**
 * 使用 Supplier 接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。提示：接口的泛型请使用
 * java.lang.Integer 类。
 */
public class Demo01SupplierTest {
    public static Integer getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,11,4,5,6,7};
        Integer maxValue = getMax(() -> {
            //获取数组的最大值返回
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("数组中最大值" + maxValue);
    }
}
