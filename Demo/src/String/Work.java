package String;

import java.util.Scanner;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 19:06
 */
public class Work {
    static Scanner scanenr = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("请输入原字符串");
        String str = scanenr.nextLine();
        System.out.println("请输入指定的字符串");
        String str1 = scanenr.nextLine();
        System.out.println(str.indexOf(str1));
        System.out.println(str.substring(9));
        way1(str,str1);
        way2(str,str1);
    }

    /**
     * 使用indexOf和subString方法，循环判断并截取
     */
    public static void way1(String str,String str1) {
        int count = 0;
        System.err.println(str.indexOf(str1));
        while(str.indexOf(str1) >= 0) {
            str = str.substring(str.indexOf(str1) + str1.length());
            count++;
        }
        System.out.println(str.indexOf(str1));//str已经成""了所以是-1
        System.out.println(str.substring(str.indexOf(str1) + str1.length()));//str为"" str1为“q”
        System.out.println("指定字符串在原字符串出现" + count + "次");
    }

    /**
     * 使用replace方法将字符串替换为空，然后求长度
     * @param str
     * @param str1
     */
    public static void way2(String str,String str1) {
        int count = (str.length() - str.replace(str1,"").length()) / str1.length();
        System.out.println(str.length());
        System.out.println(str1.length());
        System.out.println(str.replace(str1,"").length());
        System.out.println(str.replace(str1,""));
        System.out.println("指定字符串在原字符串出现" + count + "次");
    }
}
