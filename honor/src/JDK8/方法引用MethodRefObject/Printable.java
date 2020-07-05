package JDK8.方法引用MethodRefObject;

/**
 * 定义一个打印的函数式接口
 */
@FunctionalInterface
public interface Printable {
    //定义打印字符串得抽象方法
    void print(String s);
}
