package ThreadDemo;

/**
 * 使用匿名内部类创建线程
 *
 * 匿名：没有名字
 * 内部类：写在类的内部
 *
 * 匿名内部类：简化代码
 *  把子类继承父类，重写父类方法，创建子类对集合进一步操作
 *  把实现类的实现类接口，重写接口中的方法，创建实现类对集合进一步操作
 * 匿名内部类的最终产物：子类/实现类对象，这个类没有名字
 *
 * 格式：new 父类/接口(){
 *     重写父类/接口的方法
 * };
 */
public class InnerThread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }.start();
    
        Runnable thread = new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "a");
                }
            }
        };
        new Thread(thread).start();


        new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "=a");
                }
            }
        }).start();
    }
}
