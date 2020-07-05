package Math;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 18:22
 */
/*
java.util.Math类是数学相关的工具类
 */
public class Demo {

    public static void main(String[] args) {
        //获取绝对值
        System.out.println(Math.abs(12.45));
        System.out.println(Math.abs(-12.45));

        //向上取整
        System.out.println(Math.ceil(12.6));
        System.out.println(Math.ceil(-12.6));

        //向下取整
        System.out.println(Math.floor(12.6));
        System.out.println(Math.floor(-12.6));

        //四舍五入
        System.out.println(Math.round(12.6));
        System.out.println(Math.round(-12.6));
    }

}
