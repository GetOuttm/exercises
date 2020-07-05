package JDK8.方法引用MethodRefObject.StaticMethodReference;

/**
 * 方法引用_通过类名引用静态成员
 * 类已经存在，静态成员方法已经存在
 */
public class Demo01StaticMethodReference {
    //定义一个方法，参数传递要计算绝对值的整数和函数式接口Caltable
    public static int method(int num,Caltable caltable) {
        return caltable.calsAbs(num);
    }

    public static void main(String[] args) {
        int method = method(-22, num ->  Math.abs(num));
        System.out.println(method);


        //使用方法引用优化
        int method1 = method(-33, Math::abs);
        System.out.println(method1);

    }
}
