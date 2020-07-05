package Lambda;

public class LamdbaDemo {
    public static void main(String[] args) {
        //使用匿名内部类
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        //使用Lamdba表达式
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            }).start();


        //优化Lamdba
        new Thread(()-> System.out.println(Thread.currentThread().getName()) ).start();
    }
}
