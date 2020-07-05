package Demo01;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/12 16:20
 */

import java.util.Arrays;
import java.util.List;

/**
 * 面向过程，当需要一个实现功能时，每一个具体的步骤都需要亲力亲为，详细处理每一个细节
 * 面向对象，当需要实现一个功能时，不关心具体的步骤，而是找一个已经具备该功能的人，来帮我做这件事
 */
public class Demo01PrintArray {

    public static void main(String[] args) {
        int[] arr = {1,12,48,45,3,448,12};
        //要求按照[1,12,48,45,3,448,12]打印   使用面向过程

        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {//如果是最后一个元素
                System.out.println(arr[i] + "]");
            } else {
                System.out.println(arr[i] + ",");
            }
        }


        //面向对象
        System.out.println("===============================");

        System.out.println(Arrays.toString(arr));
        aVoid(12);
    }

    public static void aVoid(int a){
        System.out.println(a + "....");
        int b = 0;
        System.out.println(b);
    }

}
