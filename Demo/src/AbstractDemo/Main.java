package AbstractDemo;

import java.util.ArrayList;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 19:10
 */
public class Main {

    public static void main(String[] args) {
        Manger manger = new Manger("群主",100);
        Menber one = new Menber("成员1",0);
        Menber two = new Menber("成员2",0);
        Menber three = new Menber("成员3",0);

        manger.show();
        one.show();
        two.show();
        three.show();
        System.out.println("======================");

        //发红包
        ArrayList<Integer> arrayList = manger.send(10,3);

        one.receive(arrayList);
        two.receive(arrayList);
        three.receive(arrayList);

        manger.show();
        one.show();
        two.show();
        three.show();
    }
}
