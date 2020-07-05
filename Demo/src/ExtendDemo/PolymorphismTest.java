package ExtendDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 19:30
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        Father child = new Child();
        child.func1();//打印结果将会是什么？
//        child.func1(68);
    }
}
