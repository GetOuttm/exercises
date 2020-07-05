package RandomDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 9:57
 */
//猜数字

import java.util.Random;
import java.util.Scanner;

/**
 * 1.产生随机数字，不可改变
 * 2.需要键盘输入
 * 3.获取键盘输入的数字
 * 4.得到两个数字进行比较
 */
public class Demo02 {

    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        System.out.println(num);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字");
            int result = scanner.nextInt();

            if (num == result) {
                System.out.println("恭喜你猜对了");
                break;
            } else if (num > result) {
                System.out.println("太小了");
            } else {
                System.out.println("太大了");
            }
        }
    }
}
