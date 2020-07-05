package StringDemo;

import java.util.Scanner;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:25
 */
public class Work {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("请输入原字符串：");
        String st = sc.next();
        System.out.println("请输入指定字符串：");
        String M = sc.next();
        way1(st, M);
        way2(st, M);
    }

    /**
     * 方法一：使用indexOf和subString方法，循环判断并截取
     */
    public static void way1(String st, String M) {
        int count = 0;
        while (st.indexOf(M) >= 0) {
            st = st.substring(st.indexOf(M) + M.length());
            count++;
        }
        System.out.println("指定字符串在原字符串中出现：" + count + "次");
    }

    /**
     * 方法二：使用replace方法将字符串替换为空，然后求长度
     */
    public static void way2(String st, String M) {
        int count = (st.length() - st.replace(M, "").length()) / M.length();
        System.out.println("指定字符串在原字符串中出现：" + count + "次");
    }
}