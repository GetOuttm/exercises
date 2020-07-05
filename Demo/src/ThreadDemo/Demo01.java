package ThreadDemo;

/*
主线程：执行主(main)方法的线程

单线程程序：java程序中只有一个线程
执行从mian方法开始，从上至下执行
 */
public class Demo01 {
    public static void main(String[] args) {
        Person person = new Person("张三");
        person.run();


        Person person1 = new Person("李四");
        person1.run();
    }
}
