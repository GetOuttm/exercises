package Basis;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 9:11
 */
public class Method02 {

    public static void main(String[] args) {
        int[] arr = {45,45,8,9,145,14855,4121,4};

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
