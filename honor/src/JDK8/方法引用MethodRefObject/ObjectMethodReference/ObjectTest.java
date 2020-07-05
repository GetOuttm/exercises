package JDK8.方法引用MethodRefObject.ObjectMethodReference;

/**
 * 通过对象名引用成员方法
 * 前提是对象存在，成员方法存在，就可以使用对象名来引用成员方法
 */
public class ObjectTest {
    //定义一个方法，参数传递Printable接口，打印字符串
    public static void printString(Printable p) {
        p.print("Hello");
    }

    public static void main(String[] args) {
        printString(s -> new Demo01ObjectMethodReference().printUpperCaseString(s));

        /**
        * 使用方法引用优化
         *对象Demo01MethodRefObject存在
         * 成员方法存在printUpperCaseString
         * 可以使用对象名引用成员方法
        */
        Demo01ObjectMethodReference method = new Demo01ObjectMethodReference();
        printString(method::printUpperCaseString);
    }
}
