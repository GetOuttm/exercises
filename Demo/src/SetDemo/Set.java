package SetDemo;

/**
 * 可变参数：是jdk1.5之后出现的新特性
 * 前提;
 *      当方法的参数列表数据类型已经确定，但是参数的个数不确定，就可以使用可变参数
 * 格式：
 *  修饰符 返回值类型 方法名(数据类型... 变量名){}
 *
 * 原理”
 *      可变参数底层就是一个数组，根据传递参数的个数不同，会创建不同长度的数组，来存储这些参数，
 *      传递的参数个数，可以是0个(不传递) ，1，2，3...多个
 */
public class Set {

    public static void main(String[] args) {
        int i = add();
        System.out.println(add(10, 20, 12));
    }
    /*
    可变参数的注意事项：
        1.一个方法的参数列表，只能有一个可变参数
        2. 如果方法的参数有多个，那么可变参数必须写在参数的列表的末尾
     */
    public static void method(String a,double d,int... b){}

    /*
    可变参数的特殊(终极)写法
     */
    public static void method1(Object... o){}

    public static int add(int... a) {
        System.out.println(a);
        System.out.println(a.length);
        
        int num = 0;
        for (int i : a) {
            num += i;
        }
        return num;
    }

}
