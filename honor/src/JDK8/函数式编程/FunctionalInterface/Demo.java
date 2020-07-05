package JDK8.函数式编程.FunctionalInterface;

/**
 * 函数式接口的使用：一般可以作为方法的参数和返回值类型
 */
public class Demo {
    //定义一个方法，使用函数式接口
    public static void show(Demo01FunctionalInterface fi) {
        fi.method();
    }

    public static void main(String[] args) {
        //调用show方法，方法的参数是一个接口，所以可以传递接口的实现方法
        show(new Demo01FunctionalInterfaceImpl());

        //调用show方法，方法的参数是一个接口，所以可以传递接口的匿名内部类
        show(new Demo01FunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口的抽象方法");
            }
        });

        //调用show方法，方法的参数是一个函数式接口，所以我们可以传递lambda表达式
        show(() -> {
            System.out.println("使用Lambda表达式重写接口的抽象方法");
        });

        //简化Lambda表达式
        show(() -> System.out.println("使用简化Lambda表达式重写接口的抽象方法"));
    }
}
