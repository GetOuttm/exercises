package JDK8.方法引用MethodRefObject.ArrayMethodReference;

import java.util.Arrays;

/**
 * 数组的构造器引用
 */
public class Test {
    //定义一个方法，参数传递创建按数组的长度和ArrayBuilder接口，根据长度创建数组并返回
    public static int[] createArray(int length,ArrayBuilder arrayBuilder) {
        return arrayBuilder.builderArray(length);
    }

    public static void main(String[] args) {
        int[] array = createArray(10, l -> new int[l]);
        System.out.println(array.length);

        //优化
        int[] array1 = createArray(20, int[]::new);
        System.out.println(Arrays.toString(array1));
        System.out.println(array1.length);
    }
}
