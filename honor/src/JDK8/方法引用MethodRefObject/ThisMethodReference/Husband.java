package JDK8.方法引用MethodRefObject.ThisMethodReference;

/**
 * 通过this引用本类的成员方法
 */
public class Husband {
    //定义一个买房子的成员方法
    public void buyHouse() {
        System.out.println("北京二环内买一套四合院");
    }

    //定义一个结婚买房子，参数传递Richtable接口
    public void marry(Richtable richtable) {
        richtable.buy();
    }

    //定义一个高兴的方法
    public void soHappy() {
        //调用结婚的接口，参数传递Richtable是一个函数式接口，传递Lambda表达式
        marry(() -> this.buyHouse());

        //优化
        marry(this::buyHouse);
    }

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}
