package StaticDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:52
 */
public class MyClass {

    int num;//成员变量
   static int a;//静态变量

    public void method(){
        System.out.println("普通方法");
        //成员方法可以访问成员变量
        System.out.println(num);
        //成员方法可以访问静态变量
        System.out.println(a);
    }

    //静态方法不能使用this
    //this代表当前对象，通过谁调用的方法，谁就是当前对象
    public static void method01(){
        System.out.println("静态方法");
        //静态方法不能访问成员变量
        //因为在内存中现有的静态内容后有的非静态内容
//        System.out.println(num);
        //静态方法可以访问静态变量
        System.out.println(a);
        //静态方法不能使用this关键字
//        System.out.println(this);
    }
}
