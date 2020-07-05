package ThreadDemo.ThreadPool;

public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一个新线程");
    }
}
