package Arrays;

import java.util.Arrays;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 18:07
 */
public class Demo {

    public static void main(String[] args) {
        int[] arr = {1,5,6,2,3,7,1,45};
        int arrays = Arrays.binarySearch(arr,2);
        System.out.println(arrays);

        //转换字符串
        String str = Arrays.toString(arr);
        System.out.println(str);


        /**
         * 如果是数值，默认从小到达升序
         * 如果是字符串按照字母升序
         * 如果是自定义的类型，那么这个自定义的类需要Comparable或者Comparator的接口支持。
         */
        //排序  从小到大
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String[] strings = {"d","s","g"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
