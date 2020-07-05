package AbstractDemo;

import java.util.ArrayList;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 18:54
 */
//群主
public class Manger extends User {

    public Manger() {

    }

    public Manger(String name,int price) {
        super(name, price);
    }

    public ArrayList<Integer> send(int totalMoney,int count){
        //储蓄若干红包
        ArrayList<Integer> arrayList = new ArrayList<>();

        //看群主有多少钱
        int leftMoney = super.getPrice();
        if (leftMoney < totalMoney) {
            System.out.println("余额不足！");
            return arrayList;
        }

        //扣钱，设置新余额
        super.setPrice(leftMoney - totalMoney);

        //红包平均
        int avg = totalMoney / count;
        int mod = totalMoney % count;//零头

        //零头给最后一个人
        for (int i = 0; i < count - 1; i++) {
            arrayList.add(avg);
        }

        //最后一个人
        int last = avg + mod;
        arrayList.add(last);


        return arrayList;
    }


}
