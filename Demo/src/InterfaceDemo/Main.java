package InterfaceDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/15 18:22
 */

/**
 * 接口可以继承多个接口
 * 注意：
 * 1.多个父接口中的抽象方法重复，没关系
 * 2.多个夫接口中的默认方法重复，那么子接口必须进行默认方法的覆盖重写，【而且必须带着default关键字】
 *
 * 1.使用接口时候，接口没有静态代码块或者构造方法
 * 2.一个类可以实现多个接口
 * 3.如果实现类所需实现的多个接口中。有重复的抽象方法，那么只需要覆盖重写一次即可
 * 4.如果实现类没有覆盖重写所有接口中的所有抽象方法，那么实现类就必须是一个抽象类
 * 5.既然可实现多接口，多个重复的默认方法，那么实现类一定要对冲突的默认方法覆盖重写
 * 6.一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，默认使用父类当中的方法
 */
public class Main {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.methodInterface();

        //此方法虽未实现，使用的是接口中的方法，因为实现类中没有会到接口中找
        demo01.meyhodInterface1();//这是默认方法
        /**
         * 不能通过接口实现类的对象来调用接口当中的静态方法
         * 通过接口名直接点静态方法
         */
        Demo.methodInterfaceStatic();
        System.out.println(Demo.NUM_A_CLASS);

        Demo02  demo02 = new Demo02();
        demo02.methodInterface();
        demo02.meyhodInterface1();//覆盖重写了接口中的默认方法
        demo02.one();
        /**
         * 因为java版本低于1.9所以会出现错误
         */
//        demo02.one();
//        demo02.two();

        System.out.println("===========");
        demo01.one();
    }
}
