package AbstractDemo;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 19:04
 */

//普通成员
public class Menber extends User {

    public Menber() {

    }

    public Menber(String name,int price) {
        super(name,price);
    }

    public void receive(ArrayList<Integer> arrayList) {
        //随机抽取红包
        //获取集合当中的索引
        int index = new Random().nextInt(arrayList.size());

        //删除集合中找到的索引并且加到自己的钱中
        int delta = arrayList.remove(index);
        //获取当前成员的钱
        int price =  super.getPrice();
        //加钱并且重新改钱值
        super.setPrice(price + delta);
    }
}
