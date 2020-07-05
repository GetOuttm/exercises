package ExtendDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 19:29
 */
public class Child extends Father {

    //func1(int i)是对func1()方法的一个重载，主要不是重写！
    //由于在父类中没有定义这个方法，所以它不能被父类类型的引用调用
    //所以在下面的main方法中child.func1(68)是不对的
    public void func1(int i){
        System.out.println("BBB");
    }
    //func2()重写了父类Father中的func2()方法
    //如果父类类型的引用中调用了func2()方法，那么必然是子类中重写的这个方法
    public void func2(){
        System.out.println("CCC");
    }
}
