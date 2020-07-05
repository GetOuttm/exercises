package ThreadDemo.SynchronizedThreadDemo.SynchrinizedDemo2;

/**
 * 实现卖票案例
 *
 * 解决线程安全的第二种方式：使用同步方法
 *
 * 步骤：
 *  使用共享数据的代码抽取出来。放到一个方法中，
 *  在方法上添加synchronized修饰符
 *
 *格式：定义方法的格式
 * 修饰符：synchronized  返回值类型 方法名(参数列表){
 *     可能会出现线程安全问题的代码(访问了共享数据的代码)
 * }
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private int ticket = 100;

    //设置线程任务：卖票
    @Override
    public void run() {
        System.out.println("this:" + this);
        //使用死循环，让卖票重复操作
        while (true) {
            method();
        }
    }

    /**
     * 定义一个同步方法
     * 同步方法也会把方法内部的代码锁住
     * 只让一个线程执行
     * 同步方法的锁对象是谁？
     * 就是实现类对象new RunnableImpl();   也就是this
     */
    public synchronized void method(){

        /**
         * 把上面方法的synchronized注释
         * synchronized(this){代码}
         */
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


