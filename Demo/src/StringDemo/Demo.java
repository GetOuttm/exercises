package StringDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 11:44
 */
public class Demo {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";

        int a = str.indexOf("www");//没有就是-1
        System.out.println(a);

        /**
         *  将指定字符串连接到此字符串的结尾。
         */
        String string = "wqe";
        String s = str.concat(string);
        System.out.println(s);


        /**
         * 将此字符串转换为一个新的字符数组。
         */
        char[] chars = str.toCharArray();
        System.out.println("======");
        System.out.println(chars);

        /**
         *  使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
         */
        byte[] bytes = str.getBytes();
        System.out.println(bytes);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        /**
         * 满足的内容转换为指定内容
         */
        String q = str.replace("q", "12");
        System.out.println(q);
    }
}
