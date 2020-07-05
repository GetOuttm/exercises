package 泛型Demo;

/**
 * 含有泛型的接口，
 * 第一种使用方法
 *          定义接口的实现类，实现接口，指定接口的泛型
 * 第二种方法
 *
 */
public class GenericInterfaceImpl implements GenericInterface<String> {

    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
