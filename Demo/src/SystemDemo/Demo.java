package SystemDemo;

import java.util.Arrays;

/**
 * java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或者系统操作
 *
 * public static long currentTimeMillis();返回以毫秒为单位的当前时间
 * public static void arrayCopy(Object src,int srcPos,Object dest,int destPos,int length);
 * 讲数组指定的数据拷贝到另一个数组中
 */
public class Demo {

    public static void main(String[] args) {
        //可以用来测试程序的效率，就是所用时间
        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            System.out.println("lalalal");
//        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        /**
         *src - 源数组。
         * srcPos - 源数组中的起始位置。
         * dest - 目标数组。
         * destPos - 目标数据中的起始位置。
         * length - 要复制的数组元素的数量。
         */
        int[] arr = {1,2,3,4,5,6};
        int[] ints = {4,5,6,7,8,9,10,11};

        //个数不发生改变
        System.out.println("复制前" + Arrays.toString(ints));
        System.arraycopy(arr,0,ints,2,3);
        System.out.println("复制后" + Arrays.toString(ints));

    }
}
