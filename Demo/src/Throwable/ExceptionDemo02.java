package Throwable;

import java.util.List;

/**
 * throw
 *  可以使用throw关键字在指定的方法中抛出指定的异常
 *  必须写在方法的内部，throw关键字后面new的对象必须是Exception或者Exception子类的对象
 *
 */
public class ExceptionDemo02 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3,5,6};
        int num = getNum(arr, 10);
        System.out.println(num);

    }

    public static int getNum(int[] arr,int index) {
        if (arr == null) {
            throw new NullPointerException("数组为空");
        }
        if (index<0 || index>arr.length-1) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        int e = arr[index];
        return e;
    }
}
