package ThreadDemo;

public class Demo02 extends Thread {
    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();



        for (int i = 0; i < 20; i++) {
            System.out.println("main" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run" + i);
        }
    }
}