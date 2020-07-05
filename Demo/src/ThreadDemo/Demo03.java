package ThreadDemo;

public class Demo03 {
    public static void main(String[] args) {
        MyThreadRunable thread = new MyThreadRunable();
        Thread th = new Thread(thread);
        th.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyThreadRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("runnable" + i);
        }
    }
}
