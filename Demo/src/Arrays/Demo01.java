package Arrays;

import java.util.Arrays;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 18:15
 */
//升序并倒序打印
public class Demo01 {
    public static void main(String[] args) {
        String str = "khjfds1222afdsyahfdsakfjdsa";

        //必须是数组才能用Arrays
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        //倒序
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }

    }
}
