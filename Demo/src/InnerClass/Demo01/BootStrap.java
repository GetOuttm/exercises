package InnerClass.Demo01;

/**
 * 场景说明：
 *  红包发出去之后，所有人都有红包，大家抢到之后，最后一红包给群主
 *
 *  设置程序标题通过构造方法的字符串参数
 *  设置群主名称
 *  设置分发策略。平均、手气
 *
 *  1.普通红包，余数放到最后一个红包中
 *  2.手气红包：最少一分钱。最多不超过平均数的二倍
 */
public class BootStrap {

    public static void main(String[] args) {
        MyClass myClass = new MyClass("红包");

        //设置群主名称
        myClass.setOwnerName("爸爸");

        //普通红包
//        OpenMode open = new Open();
//        myClass.setOpenWay(open);

        //手气红包
        OpenMode mode = new RandomOpen();
        myClass.setOpenWay(mode);
    }

}
