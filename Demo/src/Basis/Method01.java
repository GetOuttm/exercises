package Basis;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/12 16:09
 */
public class Method01 {

    public static void main(String[] args) {
        int[] arr = {1,2,5,9,44545,1,23,565,56};

        System.err.println(arr.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
