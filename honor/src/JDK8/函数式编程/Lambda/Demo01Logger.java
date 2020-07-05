package JDK8.函数式编程.Lambda;

/**
 * 日志案例
 *
 * 发现以下代码存在性能浪费的问题
 *  调用log方法，传递的第二个参数是一个拼接后的字符串
 *  先把字符串拼接好在调用log方法
 *  如果log方法的日志级别不是1级，那么字符串就白拼接了存在浪费
 */
public class Demo01Logger {
    //level日志等级   msg日志信息
    private static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        String msgA = "hello";
        String msgB = "world";
        String msgC = "java";

        log(1,msgA + msgB + msgC);
    }
}
