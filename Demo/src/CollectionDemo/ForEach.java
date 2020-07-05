package CollectionDemo;

import java.util.ArrayList;

public class ForEach {

    public static void main(String[] args) {
        int[] arr = {1,54,4,4,7,65,2,23,5,2};
        for (int i : arr) {
            System.out.println(i);
        }
        /**
         * 新for循环必须有被遍历的目标，目标只能是数组或Collection
         */
    }
}
