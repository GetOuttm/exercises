package 泛型Demo;

/**
 * 含有泛型的接口，
 * 第一种使用方法
 *          定义接口的实现类，实现接口，指定接口的泛型
 * 第二种方法
 *      接口是什么类型，实现类就是什么类型
 *
 */
public class GenericInterfaceImpl01<S> implements GenericInterface<S> {

    @Override
    public void method(S s) {
        System.out.println(s);
    }
}
