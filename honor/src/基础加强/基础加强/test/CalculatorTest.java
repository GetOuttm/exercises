package 基础加强.基础加强.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import 基础加强.基础加强.junit.Calculator;

public class CalculatorTest {

    /**
     * 初始化方法:用于资源申请，所有测试方法执行之前都会先执行
     */
    @Before
    public void init() {
        System.out.println("我先执行");
    }

    /**
     * 释放资源方法：用于释放资源，所有测试方法执行完之后在执行
     */
    @After
    public void close() {
        System.out.println("我最后执行");
    }

    @Test
    public void testAdd(){
        System.out.println("我被执行了");
        //创建计算器对象
        Calculator calculator = new Calculator();
        int add = calculator.add(1, 3);
        System.out.println(add);
        System.out.println(calculator.sub(7,8));

        //断言，断言这个程序的运行结果
        Assert.assertEquals(3,add);
    }
}
