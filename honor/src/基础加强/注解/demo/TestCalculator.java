package 基础加强.注解.demo;

import java.io.*;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 当主方法执行会自动执行被检测的方法(加了@Check注解的方法，判断方法是否有异常，记录到文件中)
 */
public class TestCalculator {
    public static void main(String[] args) throws IOException {
        //1.创建计算器对象
        Calculator c = new Calculator();
        //2.获取字节码对象
        Class cls = c.getClass();;
        //3.获取所有方法
        Method[] methods = cls.getMethods();

        int num = 0;//出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            //4.判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                //5.有，执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //6.捕获异常

                    //7.记录文件信息到文件中
                    num ++;

                    bw.write( method + "类"+ method.getName()+"方法出现异常了");
                    bw.newLine();
                    bw.write("异常的名称:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因:" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("==========================");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试出现" + num + "次异常");

        bw.flush();
        bw.close();
    }
}
