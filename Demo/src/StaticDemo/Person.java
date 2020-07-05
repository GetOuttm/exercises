package StaticDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 17:58
 */
/*
静态代码块
static {
      //内容
}
当用到本类，静态代码块执行唯一的一次
 */
public class Person {

    static {
        System.out.println("静态代码块");
    }

    public Person() {
        System.out.println("构造方法");
    }
}
