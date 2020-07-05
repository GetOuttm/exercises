package JDK8.函数式编程.Lambda;

/**
 * 使用Lambda优化日志案例
 * Lambda的特点：延迟加载
 * 使用前提：必须存在函数式接口
 */
public class Demo02Lambda {
    //定义一个显示日志的方法，方法的参数传递日志的等级和MessageBuilder接口
    public static void showLog(int level, MessageBuilder mb) {
        //对日志的等级进行判断如果是一级调用MessageBuilder接口的builderMessage方法
        if (level == 1) {
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        String msgA = "hello";
        String msgB = "world";
        String msgC = "java";

        //调用showLog方法，参数MessageBuilder是一个函数式接口，可以使用Lambda表达式
//        showLog(2,() -> msgA + msgB + msgC);


        /*
            使用Lambda表达式作为参数，只是把参数传递到showLog方法中
            只有满足条件：日志的等级是1
                才会调用MessageBuilder中的方法builderMessage，才会拼接字符串
            如果条件不满足，日志的等级不是1级
                那么MessageBuilder中的方法builderMessage也不会执行，那么也不会执行拼接字符串
            所以不会存在性能的浪费
         */
        showLog(2,() -> {
            System.out.println("不满足条件不执行");

            return msgA + msgB + msgC;
        });
    }
}
