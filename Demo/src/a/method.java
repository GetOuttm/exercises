package a;

import java.util.Arrays;

public class method {
    public static void main(String[] args) {
        int[] array = {23,45,12,6,78,696,75,12,4,9,36};
        Arrays.sort(array);
        System.out.println(biSearch(array, 696));

        bubbleSort(array);
        sort(array);

        System.out.println(Math.round(1.5));
        System.out.println(Math.ceil(1.5));
        System.out.println(Math.floor(1.5));

        String s = "123456789";
        System.out.println(s.charAt(3));
    }

    //二分查找   数组必须是有序的，所以先进行排序
    public static int biSearch(int[] array,int a) {
        //[4, 6, 9, 12, 12, 23, 36, 45, 75, 78, 696]
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;//中间位置
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) {//向右查找
                left = mid + 1;
            } else {//向左查找
                right = mid - 1;
            }
        }
        return -1;
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {//外层控制循环趟数
            for (int j = 1; j < array.length - i; j++) {//内层循环为当前i趟，所需要比较的次数
                if (array[j-1] > array[j]) {//前面的数字大于后面的数字就交换
                    int temp;
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //插入排序
    public static void sort(int[] array) {
        for(int i =1; i<array.length;i++) {
            //插入的数
            int insertVal = array[i];
            //被插入的位置(准备和前一个数比较)
            int index = i-1;
            //如果插入的数比被插入的数小
            while(index>=0&&insertVal<array[index]) {
                //将把 arr[index] 向后移动
                array[index+1]=array[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            array[index+1]=insertVal;
        }
        System.out.println(Arrays.toString(array));
    }

    //快速排序

    //希尔排序

    //归并排序
}
