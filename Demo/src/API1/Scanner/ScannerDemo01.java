package API1.Scanner;

import java.util.Scanner;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 10:25
 */
public class ScannerDemo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * next()方法读取到空白符就结束l；
         * nextLine()读取到回车结束也就是“\r”；
         */
        System.out.println("请输入字符串（nextLine）：");
        String str1 = scanner.nextLine();
        System.out.println(str1);

        System.out.println("请输入字符串（next）：");
        String str = scanner.next();
        System.out.println(str);



    }
}
