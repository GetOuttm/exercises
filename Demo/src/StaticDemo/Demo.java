package StaticDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:53
 */
/*
一旦使用static修饰成员方法，那就是静态方法，
静态方法不属于对象，属于类
先创建对象才能使用static修饰修饰的方法
 */
public class Demo {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.method();
        myClass.method01();//不推荐  编译之后会被javac翻译成类名点
        //对于静态方法，通过对象或类名点都可以但是推荐类名点
        MyClass.method01();

        method();
        Demo.method();
    }

    public static void method() {
        System.out.println("自己的方法");
    }
}
