package JDK8.函数式编程.Lambda;

/***
 * 例如 java.lang.Runnable 接口就是一个函数式接口，假设有一个 startThread 方法使用该接口作为参数，那么就
 * 可以使用Lambda进行传参。这种情况其实和 Thread 类的构造方法参数为 Runnable 没有本质区别。
 */
public class Demo03Runnable {
    public static void startThread(Runnable runnable) {
        //开启多线程
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        //调用startThread方法，参数是一个接口，可以传递匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动");
            }
        });

        //调用startThread方法，参数是一个接口，可以使用Lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "线程启动"));


    }
}
