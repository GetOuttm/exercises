package ThreadDemo.SynchronizedThreadDemo.SynchrinizedDemo2;

/**
 * 模拟卖票
 * 创建三个线程，同时开启，对共享的票进行售卖
 *
 * 同步方法
 */
public class Demo {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        System.out.println("run:" + runnable);

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();
    }
}
