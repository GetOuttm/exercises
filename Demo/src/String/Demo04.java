package String;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 19:06
 */
public class Demo04 {
    public static void main(String[] args) {
        String str = "fjlkdshklfdjhksahfkdjhslafdsa";

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int in = str.length();
            char c = str.charAt(i);

            //定义一个字符等于字符串第一个字符，每次统计完会将统计过的字符替换掉
            String s = str.replaceAll(c + "","");//定义一个新字符串将出现的字符
            //赋值一个新的字符串
            int arr = s.length();
            count = in - arr;//旧的长度减去新的长度就是字符出现的 次数
            str = s;//将替换并统计过次数的字符串赋给原来的字符串,便于下一次遍历
            System.out.println("字符" + c + "出现了" + count + "次");
        }
    }
}
