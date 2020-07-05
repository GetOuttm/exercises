package RandomDemo;

import java.util.Random;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 9:44
 */
public class Demo {

    public static void main(String[] args) {
        Random random = new Random();
        int o = random.nextInt(12);//参数代表范围  [0,12)   0-11
        int i = random.nextInt();//随机获取int范围内的数字
        System.out.println(i);
        System.out.println(o);
        System.out.println("=============");
        for (int j = 0; j < 100; j++) {
            System.out.println(random.nextInt(10));//0-9
        }
    }
}
