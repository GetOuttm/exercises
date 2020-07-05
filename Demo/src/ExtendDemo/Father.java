package ExtendDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 19:29
 */
public class Father {

    public void func1(){
        func2();
    }
    //这是父类中的func2()方法，因为下面的子类中重写了该方法
    //所以在父类类型的引用中调用时，这个方法将不再有效
    //取而代之的是将调用子类中重写的func2()方法
    public void func2(){
        System.out.println("AAA");
    }
}
