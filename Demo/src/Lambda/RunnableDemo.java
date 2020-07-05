package Lambda;

/**
 * 使用实现Runnable的方式实现多线程程序
 */
public class RunnableDemo {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
        thread.start();

        //简化代码，使用匿名内部类

        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();


        System.out.println(2<<2);
    }
}
