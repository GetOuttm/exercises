package ArrayListDemo.Demo01;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 10:21
 */

/*
数组一旦创建，程序运行期间长度不可发生改变
 */
public class Demo {

    public static void main(String[] args) {
        //创建长度为3的数组，存储Person对象
        Person[] array = new Person[3];

        Person one = new Person("哈哈",36);
        Person two = new Person("拉拉",45);
        Person three = new Person("略略略",78);

        array[0] = one;
        array[1] = two;
        array[2] = three;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);//地址值
            System.out.println(array[i].getName());
        }
    }
}
