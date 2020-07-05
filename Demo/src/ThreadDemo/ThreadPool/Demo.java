package ThreadDemo.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *      就是容纳多个线程的容器，其中的线程可以反复使用，省去了创建和销毁线程的操作，无需反复创建销毁而消耗过多资源
 *
 * 线程池的好处
 *  1.降低资源消耗。减少创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
 *  2.提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行
 *  3.提高线程的可管理性。可以根据系统的承受能力，调整线程池工作线程的数目，防止因为消耗过多的内存，而把服务器弄宕机，
 *      (每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大， 最后死机。)
 */
public class Demo {
    /**
     * java.util.concurrent.Executors
     * static ExecutorService newFixedThreadPool(int nThreads)
     *           创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
     * 参数：
     *      nThreads - 池中的线程数
     * 返回：
     * ExecutorService接口，返回的是ExecutorService接口的实现类对象
     *      新创建的线程池
     *
     *
     * java.util.concurrent.ExecutorService   线程池接口
     *  用来从线程池中获取线程，调用start方法，执行线程任务
     *  Future<?> submit(Runnable task)
     *           提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
     *
     *  关闭销毁线程池的方法 void shutdown()
     *           启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
     */

    /**
     * 线程池的使用步骤
     *  1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一定数量的线程池
     *  2.创建一个类，实现Runnable接口，重写run方法，设置线程任务
     *  3.调用ExecutorService接口中的submit，传递线程任务(实现类)，开启线程，执行run方法
     *  4.调用ExecutorService中的shutdown销毁线程池
     */

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new ThreadDemo());
        pool.submit(new ThreadDemo());
        pool.submit(new ThreadDemo());
        pool.submit(new ThreadDemo());
        pool.submit(new ThreadDemo());
        pool.submit(new ThreadDemo());
        pool.submit(new ThreadDemo());
        //线程池会一直开启，使用完线程，会把线程归还给线程池


        pool.shutdown();


        pool.submit(new ThreadDemo());//会抛出异常，因为线程池已经销毁了
    }
}
