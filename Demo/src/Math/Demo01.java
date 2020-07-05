package Math;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 18:31
 */
/*
计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数
 */
public class Demo01 {
    public static void main(String[] args) {
        int random = (int) (Math.random()*100);
        System.out.println(random);

        int count = 0;
        double min = -10.8;
        double max = 5.9;
        for (int i = (int) min; i < max; i++) {
            //向上取整
//            double m = Math.ceil(i);
//            double abs = Math.abs(m);

            //向下取整
//            double m =Math.floor(i);
//            double abs = Math.abs(m);

            int abs = Math.abs(i);
            if (abs > 6 || abs < 2.1) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count + "个");
    }
}
