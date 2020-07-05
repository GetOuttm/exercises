package a;

import java.util.concurrent.*;

public class CacheThread {

    public static void main(String[] args) {
//        cacheThreadPool();
//        singleThreadPool();
//        scheduledThreadPool();
        fixedThreadPool();

    }
    //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
    public static void cacheThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        //每一次循环创建一个线程，因为新的线程执行的时候，原有创建的线程还没结束
        for (int i = 0; i < 10; i++) {
                final int index = i;
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getId() + ">>>>" + index);
                    }
                });
        }
    }
    //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    public static void singleThreadPool(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ">>>>" + index);
                }
            });
        }
    }

    //创建一个定长线程池，支持定时及周期性任务执行。
    private static void scheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Long startTime = System.currentTimeMillis();
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延时运行时间==》" + (System.currentTimeMillis() - startTime));
                try {
                    //当此处等待时间大于周期时间时，将以这个时间为执行间隔时间，因为有等待时间
                    //如此处时间小于间隔时间时，以间隔时间为准，这时没有等待时间
                    Thread.sleep(1000 * 4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3,3, TimeUnit.SECONDS);
    }

    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    private static void fixedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(10);
        //当线程池的线程到达最大数量，如果有空闲线程就会使用空闲线程执行，如果没有空闲线程就会出现排队
        for (int i = 0; i < 20; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "==>" + index);
                }
            });
            System.out.println("当前线程池中线程数量"+((ThreadPoolExecutor)cachedThreadPool).getPoolSize());
            System.out.println("当前线程池中排队数量==》"+((ThreadPoolExecutor)cachedThreadPool).getQueue().size());
        }
    }
}
