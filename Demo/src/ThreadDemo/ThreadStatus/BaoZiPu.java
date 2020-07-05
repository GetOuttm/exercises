package ThreadDemo.ThreadStatus;

/**
 * 包子铺线程和包子线程---->通信(互斥)
 *  必须同时同步技术保证每个线程只能有一个在执行
 *  锁对象必须保持唯一，可以使用包子对象作为锁对象
 *  包子铺和吃货的类就需要把包子对象作为参数传递
 *      1. 需要在成员位置创建一个包子变量
 *      2.使用带参数的构造方法，为这个包子变量赋值，
 *
 */
public class BaoZiPu extends Thread {
    //1. 需要在成员位置创建一个包子变量
    private BaoZi bz;

    //2.使用带参数的构造方法，为这个包子变量赋值，
    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    //设置线程(run),生产包子
    @Override
    public void run() {
        //定义一个变量
        int count = 0;

        //让包子铺一直生产包子
        while (true) {
            //必须同时同步技术保证每个线程只能有一个在执行
            synchronized (bz) {
                //对包子进行判断
                if (bz.statue == true) {
                    //包子皮调用wait方法进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒只够执行，包子铺生产包子
                //增减一些循环，交替生产两种包子
                if (count%2 == 0) {
                    //生产薄皮三鲜馅包子
                    bz.pi = "薄皮";
                    bz.xian = "三鲜馅";
                } else {
                    //生产 冰皮 牛肉大葱馅
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱馅";
                }

                count++;
                System.out.println("包子铺正在生产：" + bz.pi + bz.xian + "包子");


                //生产包子需要3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //修改包子的状态为true
                bz.statue = true;

                //唤醒吃货线程，让吃货线程吃包子
                bz.notify();
                System.out.println("包子铺已经生产好了"+ bz.pi + bz.xian + "包子，吃货可以开始吃了");
            }
        }

    }
}
