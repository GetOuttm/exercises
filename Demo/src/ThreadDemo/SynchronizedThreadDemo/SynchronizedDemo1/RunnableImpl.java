package ThreadDemo.SynchronizedThreadDemo.SynchronizedDemo1;

/**
 * 实现卖票案例
 *
 * 解决线程安全的第一种方式：使用同步代码块
 * synchronized(锁对象){
 *     可能会出现线程安全问题的代码(访问了共享数据的代码)
 * }
 *
 * 注意：
 * 1.通过代码块中的锁对象，可以用任意的对象
 * 2.但是必须保证多个线程使用的锁对象是同一个
 * 3.锁对象作用：
 *      把同步代码块锁住，只让一个线程在同步代码块中执行
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private int ticket = 100;

    //创建一个锁对象
    Object object = new Object();

    //设置线程任务：卖票
    @Override
    public void run() {

        //使用死循环，让卖票重复操作
        while (true) {
            //同步代码块
            synchronized (object) {

                //先判断票是否存在
                if (ticket > 0){
                    //提高出现的问题的概率
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //票存在，卖票
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}
