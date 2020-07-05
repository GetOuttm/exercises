package RandomDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 9:50
 */

import java.util.Random;

/**
 * 根据变量N的值，随机获取数字，范围是[0,N]，也可以获取到N
 * 1.定义一个变量n，随机赋值
 * 2.来使用Random
 * 3.如果是10，那么就是0-9，然而想要的是1-10，整体+1即可
 * 4.打印
 */
public class Demo01 {

    public static void main(String[] args) {
        int n = 5;
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int result = random.nextInt(n) + 1;
            System.out.println(result);
        }
    }

}
