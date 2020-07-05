package ThreadDemo.ThreadStatus;

public class ChiHuo extends Thread {
    //1. 需要在成员位置创建一个包子变量
    private BaoZi baoZi;

    //2.使用带参数的构造方法，为这个包子变量赋值，
    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    //设置线程任务  吃包子
    @Override
    public void run() {
        //一直吃包子
        while (true) {
            //只有一个线程执行
            synchronized (baoZi) {
                if (baoZi.statue == false) {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后吃包子
                System.out.println("吃货正在吃" + baoZi.pi + baoZi.xian + "包子");

                baoZi.statue = false;
                baoZi.notify();
                System.out.println("吃货已经把" + baoZi.pi + baoZi.xian + "包子吃完了，包子铺开始生产包子");

                System.out.println("===============");
            }
        }
    }
}
