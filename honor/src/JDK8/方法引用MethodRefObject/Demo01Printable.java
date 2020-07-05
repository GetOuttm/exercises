package JDK8.方法引用MethodRefObject;

public class Demo01Printable {
    //定义一个方法，参数传递Printable接口，对字符串进行打印
    public static void prinString(Printable p) {
        p.print("HelloWorld");
    }

    public static void main(String[] args) {
        prinString(s -> System.out.println(s));

        /**
         * 分析：Lambda表达式得目的打印参数传递的字符串
         *      把参数传给了System.out对象，调用out对象中得方法println对字符串进行输出
         * 注意：
         *      1.System.out对象是已经存在的
         *      2.println方法也是存在的
         * 所以我们可以使用方法引用来优化Lambda表达式
         * 可以使用System.out方法调用println方法
         *
         * 双冒号 :: 写法，这被称为“方法引用”，而双冒号是一种新的语法。
         */
        /**
         * 方法引用符
         * 双冒号 :: 为引用运算符，而它所在的表达式被称为方法引用。如果Lambda要表达的函数方案已经存在于某个方
         * 法的实现中，那么则可以通过双冒号来引用该方法作为Lambda的替代者。
         * 语义分析
         * 例如上例中， System.out 对象中有一个重载的 println(String) 方法恰好就是我们所需要的。那么对于
         * printString 方法的函数式接口参数，对比下面两种写法，完全等效：
         * Lambda表达式写法： s -> System.out.println(s);
         * 方法引用写法： System.out::println
         * 第一种语义是指：拿到参数之后经Lambda之手，继而传递给 System.out.println 方法去处理。
         * 第二种等效写法的语义是指：直接让 System.out 中的 println 方法来取代Lambda。两种写法的执行效果完全一
         * 样，而第二种方法引用的写法复用了已有方案，更加简洁。
         * 注:Lambda 中 传递的参数 一定是方法引用中 的那个方法可以接收的类型,否则会抛出异常
         */
        prinString(System.out :: println);
    }

}
