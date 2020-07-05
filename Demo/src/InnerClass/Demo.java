package InnerClass;

/**
 * 内部类。一个事物内部包含另一个事务
 *
 * 1.成员内部类    内部访问外部随意访问， 外部访问内部需要内部类对象
 * 2.局部内部类(包含匿名内部类)  如果一个类定义在一个方法内部，那么这就是一个局部内部类
 *         ”局部“：只有当前所属的方法才能使用它，出了这个方法就不能使用了
 *         格式 ：
 *              修饰符 class 外部类名称{
 *                  修饰符 返回值类型 外部类名称名称(参数列表) {
 *                      calss 局部内部类 {
 *                          .....
 *                      }
 *                  }
 *              }
 */
public class Demo {

    public static void main(String[] args) {
        Body body = new Body();
        body.method();

        Body.Hert bh = new Body().new Hert();
        bh.beat();


        Other.Inner inner = new Other().new Inner();
        System.out.println(inner.num);
        inner.method();



        //匿名内部类
        Other other = new Other();
        other.method();


        /**
         * 类的权限修饰符  public > protected > (default) >private
         * 外部类：public / (default)
         * 成员内部类：public / protected / (default) / private
         * 匿名内部类：什么都不写
         */
    }
}
