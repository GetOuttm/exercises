package InterfaceDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/15 18:21
 */

/**
 * 如果实现类并没有覆盖重写接口中的所有抽象方法，那么这个实现来必须是抽象类
 */
public class Demo01 implements Demo,One {
    @Override
    public void methodInterface() {
        System.out.println("这是一个方法");
    }

    @Override
    public void one() {
        System.out.println("sssss");
    }
}
