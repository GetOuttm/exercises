package JDK8.函数式编程.FunctionalInterface;

/**
 * 函数式接口：有且只有一个抽象方法的接口，称之为函数式接口
 * 当然接口中可以包含其他方法(默认方法、静态方法、私有方法)
 *
 * @FunctionalInterface注解
 *   可以检测接口是否是一个函数式接口   是，编译成功，否，编译失败
 *          失败的原因：
 *              1.接口中没有抽象方法 2.抽象方法的个数大于1个
 */
@FunctionalInterface
public interface Demo01FunctionalInterface {
    //定义抽象方法
    public abstract void method();

//    void method1();
}
