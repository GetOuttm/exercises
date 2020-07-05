package 基础加强.基础加强.junit;

import 基础加强.基础加强.junit.Calculator;

/**
 * Junit单元测试
 *  测试分类：
 *      黑盒测试：不需要写代码，给输入值，看程序是否能输出期望值
 *      白盒测试:需要写代码。关注程序具体的执行流程
 *  Junit使用:白盒测试
 *      步骤：
 *          1.定义一个测试类(测试用例)
 *              建议：1.测试类名：类名+test
 *                  2.包名：xxx.xxx.xxx.test  cn.baidu.test
 *          2.定义测试方法
 *              可以独立运行
 *              建议：1.方法名test+测试的方法名   testAdd()
 *                   2.返回值 void
 *                   3.参数列表：空参
 *          3.给方法加注解@test
 *          4.导入Junit依赖环境
 *
 *   判断标准：
 *      一般使用断言操作来处理
 *          Assert.assertEquals(期望的结果,运算的结果)
 */
public class Demo01Junit {
    public static void main(String[] args) {
        //创建对象
        Calculator calculator = new Calculator();

        int add = calculator.add(1, 2);
        System.out.println(add);

        int sub = calculator.sub(1, 3);
        System.out.println(sub);
    }
}
