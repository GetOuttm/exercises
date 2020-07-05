package InnerClass;

/**
 * 如果接口的实现类或者父类的子类 只需要使用一次
 * 那么这种情况下就可以省略该类的定义，而改称【匿名内部类】
 */
public class Main {

    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.method();

        MyInterface myInterface1 = new MyInterfaceImpl();
        myInterface1.method();

        new MyInterfaceImpl().method();


        //匿名内部类
        /**
         * 格式解析
         * new  接口名称(){...}
         * new代表创建对象的动作
         * 接口名称就是匿名内部类需要实现的那个接口
         * {...}这才是匿名内部类的内容
         *
         * 注意
         * 1.匿名内部类实现接口的实现类只使用一次，使用匿名内部类
         * 2.创建对象只使用一次
         * 3.多次创建对象，而类的内容一样，使用实现类或重复new
         * 4.如果需要调用多次，就需要取个名
         */
        MyInterface myInterface2 = new MyInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写方法");
            }
        };
        new MyInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写方法");
            }
        }.method();

        myInterface2.method();



    }
}
