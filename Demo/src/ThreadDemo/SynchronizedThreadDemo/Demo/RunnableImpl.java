package ThreadDemo.SynchronizedThreadDemo.Demo;

/**
 * 实现卖票案例
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private int ticket = 100;

    //设置线程任务：卖票
    @Override
    public void run() {
        //使用死循环，让卖票重复操作
        while (true) {
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
