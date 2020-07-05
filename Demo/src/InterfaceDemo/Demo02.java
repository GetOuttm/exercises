package InterfaceDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/15 18:32
 */
public class Demo02 implements Demo,One {
    @Override
    public void methodInterface() {
        System.out.println("这是一个默认方法");
    }

    @Override
    public void meyhodInterface1() {
        System.out.println("覆盖重写了接口中的默认方法");
    }

    @Override
    public void one() {
        System.out.println("qqqqqq");
    }
}
