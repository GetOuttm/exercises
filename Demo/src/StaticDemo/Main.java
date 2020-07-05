package StaticDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 18:00
 */

/**
 * 静态优先非静态，所以静态代码块有限构造方法
 *
 * 静态代码块的典型用途
 * 用来一次性地对静态成员变量进行赋值。
 */
public class Main {

    public static void main(String[] args) {
        Person one = new Person();
        System.out.println("=========================");
        Person two = new Person();
    }
}
