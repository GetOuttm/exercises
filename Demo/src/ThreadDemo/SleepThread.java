package ThreadDemo;

/**
 * public static void sleep(long mills);//使当前正在执行的线程以指定的毫秒数暂停(程序停止运行)。
 * 毫秒数结束后，线程继续执行
 */
public class SleepThread {
    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
