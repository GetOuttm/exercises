package MultiDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/16 14:06
 */
//多态
//    父类引用指向子类对象

/**
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        Fu fz = new Zi();//父类引用指向子类对象
        //看右边new的是谁就是点谁，如果右边没有那么就找左边的
        fz.method();
        fz.methodFu();

        /**
         * 访问成员变量的两种方式
         * 1.直接通过对象名访问成员变量，等号左边是谁优先用谁，没有则向上找
         *   fz.age;这是错误的不会向下查找
         * 2.间接访问成员变量,看方法属于谁优先用谁，没有则向上找
         *      子类没有覆盖重写就是 父
         *      子类如果覆盖重写就是 子
         *
         * 编译看左，运行看左
         */
        fz.showNum();
        System.out.println(fz.num);

        /**
         * 多态代码中成员方法的访问规则
         *  看new的是谁就优先用谁，没有就向上查找
         *
         * 编译看左，运行看右
         */
        fz.method();//父子都有用zi
        fz.methodFu();//子类没有用父


    }
}
