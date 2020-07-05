package ThreadDemo.SynchronizedThreadDemo.SynchronizedStaticDemo;

/**
 * 实现卖票案例
 *
 * 解决线程安全的第二种方式：使用静态方法
 *
 *格式：定义方法的格式
 * 修饰符 static synchronized  返回值类型 方法名(参数列表){
 *     可能会出现线程安全问题的代码(访问了共享数据的代码)
 * }
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private static int ticket = 100;

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
     *  静态的同步方法
     *  锁对象是谁？
     *  不能是this，this是创建对象之后产生的，静态方法优先于对象
     *  静态方法的的锁对象是本类的class属性---->class文件对象(反射)
     */
    public static /*synchronized*/ void method(){
//        synchronized (this) {
        synchronized (RunnableImpl.class) {
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


