package Throwable;

import java.time.LocalDate;

/**
 * 异常的产生和
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int e = getElement(arr,1);//ArrayIndexOutOfBoundsException
        System.out.println(e);


        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

    public static int getElement(int[] arr,int index) {
        int ele = 0;
        try {
            ele = arr[index];
        }catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return ele;
    }
}
