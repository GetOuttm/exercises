package Lambda.Demo02;

public class Demo {
    public static void main(String[] args) {
        //使用匿名内部类
        invokeCala(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });


        //使用Lamdba表达式
        invokeCala(1,2,(int a,int b) -> {
            return a + b;
        });

        //优化
        invokeCala(1,2,(a,b) ->  a + b );
    }


    public static void invokeCala(int a,int b,Calculator calculator) {
        int sum = calculator.calc(a, b);
        System.out.println(sum);
    }
}
