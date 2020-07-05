package Lambda.Demo;

public class Cook {

    public static void main(String[] args) {
        //使用匿名内部类
        invokeMethod(new Chuzi() {
            @Override
            public void method() {
                System.out.println("拉拉");
            }
        });

        //使用Lamdba表达式
        invokeMethod(() -> {
            System.out.println("哈哈");
        });

        //优化
        invokeMethod(() -> System.out.println("哈哈"));
    }

    public static void invokeMethod(Chuzi chuzi){
        chuzi.method();
    }
}
