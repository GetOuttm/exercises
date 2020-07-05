package ThreadDemo.SynchronizedThreadDemo.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现卖票案例
 *
 * 解决线程安全的第三种方式 ：lock锁
 * java.util.concurrent.locks.lock接口
 * Lock实现提供比使用synchronized方法和语句可以获得的更广泛的锁定操作
 * Lock接口中的方法：
 *  void lock()   获取锁。
 * void unlock()  释放锁。
 *
 * java.util.concurrent.locks.ReentrantLock  implements Lock接口
 *
 *
 * 使用步骤：
 *  1.在成员位置创建一个ReentrantLock对象
 *  2.在可能会出现安全问题的代码前调用Lock接口的方法lock()获取锁
 *  3.在可能会出现安全问题的代码后调用Lock接口的方法unlock()释放锁
 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享的资源
    private int ticket = 100;

    //1.在成员位置创建一个ReentrantLock对象
    Lock lock = new ReentrantLock();



    //设置线程任务：卖票
    @Override
    public void run() {
        //使用死循环，让卖票重复操作
        while (true) {
            //2.在可能会出现安全问题的代码前调用Lock接口的方法lock()获取锁
            lock.lock();
            //先判断票是否存在
            if (ticket > 0) {
                //提高出现的问题的概率
                try {
                    Thread.sleep(10);
                    //票存在，卖票
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3.在可能会出现安全问题的代码后调用Lock接口的方法unlock()释放锁
                    lock.unlock();

                    /*
                    无论程序是否出现异常，都会释放锁，提高程序运行的效率
                     */
                }
            }
        }
    }



//    //设置线程任务：卖票
//    @Override
//    public void run() {
//        //使用死循环，让卖票重复操作
//        while (true) {
//            //2.在可能会出现安全问题的代码前调用Lock接口的方法lock()获取锁
//            lock.lock();
//            //先判断票是否存在
//            if (ticket > 0) {
//                //提高出现的问题的概率
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                //票存在，卖票
//                System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
//                ticket--;
//            }
//            //3.在可能会出现安全问题的代码后调用Lock接口的方法unlock()释放锁
//            lock.unlock();
//        }
//    }
}


