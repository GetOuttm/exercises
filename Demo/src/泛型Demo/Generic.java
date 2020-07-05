package 泛型Demo;

/**
 * 定义泛型的方法。泛型定义在方法的修饰符与返回值类型之间
 * 格式：
 *  修饰符 <泛型> 返回值类型 方法名(参数列表(使用泛型)) {
 *      方法体;
 *  }
 */
public class Generic {

    //含有泛型的方法
    public <M> void method(M m) {
        System.out.println(m);
    }

    //含有泛型的静态方法
    public static <E> void mthod(E e) {
        System.out.println(e);
    }
}
