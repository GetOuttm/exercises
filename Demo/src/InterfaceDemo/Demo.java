package InterfaceDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/15 18:17
 */

/***
 * 接口是一种引用类型，最重要的内容就是其中的抽象方法
 * 1.7接口可以包含：
 * 1.常量
 * 2.抽象方法
 * 1.8
 * 3.默认方法
 * 4.静态方法
 * 1.9
 * 5.私有方法
 */
public interface Demo {

    //直接写int a = 12;也是常量，一旦赋值不能改变
    //接口当中常量必须进行赋值
    //接口当中的常量名称使用完全大写字母，多个单词用下划线进行分割
    public static final int NUM_A_CLASS = 12;

    /**
     * 接口中的抽象方法的修饰符固定必须是public abstract
     * 可以选择性省略
     */
    public abstract void methodInterface();

    //新方法 实现类又不需要实现它可以改成如下 默认方法
//    public abstract void methodInterface1();

    //也可以被实现类重写
    public default void meyhodInterface1(){
        System.out.println("这是默认方法");
    }

    //从java8中可以定义静态方法
    public static void methodInterfaceStatic(){
        System.out.println("生活不如意十之八九，不与人言二三");
        System.out.println("这是接口的静态方法");
    }


    /**
     * 我们需要抽取一个公共方法，用来解决两个默认方法中的重复代码
     * 但是这个方法不应该让实现类使用，应该是私有化的
     *
     * 解决方案：java1.9提供了接口中可以定义私有方法
     * 1.普通私方法，解决多个默认方法之间的重复代码
     * 格式：
     * private 返回值类型 方法名称(参数列表) {方法体}
     *
     * 2.静态私有方法：解决多个静态方法之间的重复代码
     * 格式：
     * private static 返回值类型 方法名称(参数列表) {方法体}
     */
    public default void one(){
        System.out.println("默认方法1");
//        method();
    }

    public default void two(){
        System.out.println("默认方法2");
//        method();
    }


        //只能被接口使用，不能被实现类所使用
//    private void method(){
//        System.out.println("AAAA");
//        System.out.println("BBBB");
//        System.out.println("CCCC");
//    }
}
