package InnerClass;

/**
 * 局部内部类
 *      如果希望访问在方法的局部变量，那么这个变量必须是final类型
 * 从java8开始，只要局部变量不变，final关键字可以省略
 *
 *
 * 原因：
 *  new出来的对象在堆内存中
 *  局部变量是跟着方法定的，在栈内存中
 *  方法运行结束之后，立刻出栈，局部变量就回立刻消失
 *  但是new出来的对象会在堆中持续存在，知道垃圾回收消失
 */
public class MyOther {

    public void method(){
        int num = 10;//方法的局部变量
        class MyInner{
            public void inner(){
                System.out.println(num);
            }
        }
    }
}
