package ThreadDemo;

/**
 * 获取线程的方法
 *  1.使用Thread类中的getName()方法
 *      String getName()  返回线程的名称
 *  2.可以获取当前正在执行的线程，使用线程中的方法getName获取线程的名称
 *      static Thread currentThread()  返回对当前正在执行的线程的引用
 */
public class Demo04 {
    public static void main(String[] args) {
        MyName thread = new MyName();
        thread.start();
        new MyName().start();

        new MyName("san").start();

        System.out.println(thread.getName());
    }
}

class MyName extends Thread {
    public MyName(){

    }

    public MyName(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(1);
        //链式编程
        System.out.println(Thread.currentThread().getName());
    }
}