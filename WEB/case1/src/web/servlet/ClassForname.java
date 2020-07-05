package web.servlet;

public class ClassForname {

    //静态代码块
    static {
        System.out.println("执行了静态代码块");
    }
    //静态变量
    private static String staticFiled = staticMethod();

    //赋值静态变量的静态方法
    public static String staticMethod(){
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }

    public static void main(String[] args) {
        try {
            ClassLoader.getSystemClassLoader().loadClass("web.servlet.ClassForname");
            System.out.println("-----------------------------");
            Class<?> aClass = Class.forName("web.servlet.ClassForname");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
