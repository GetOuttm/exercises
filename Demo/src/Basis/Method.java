package Basis;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/11 18:22
 */
public class Method {

    public static void main(String[] args) {
        int[] arr = {12, 56, 89, 562, 1444};

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);

        //冒泡，从大到小
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
