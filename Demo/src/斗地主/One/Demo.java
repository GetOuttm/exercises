package 斗地主.One;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 准备牌
 * 洗牌
 * 发牌
 * 看牌
 */
public class Demo {

    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的ArrayList集合。泛型使用String
        ArrayList<String> arrayList = new ArrayList<>();
        //定义两个数组，一个数组存花色，一个数组存牌的符号
        String[] colors = {"♣","♥","♦","♠"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        //大王小王先存到集合中
        arrayList.add("大王");
        arrayList.add("小王");

        //循环组装52张牌
        for (String number : numbers) {
            for (String color : colors) {
                arrayList.add(color + number);
            }
        }
        System.out.println(arrayList);


        //2.洗牌，使用Collections的方法
        /*
        static void shuffle(List<?> list)
          使用默认随机源对指定列表进行置换。
         */
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        //3.发牌
        //定义4个集合。存储玩家的牌和底牌
        ArrayList<String> pai = new ArrayList<>();
        ArrayList<String> pai1 = new ArrayList<>();
        ArrayList<String> pai2 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        //遍历arrayList集合获取每一张牌，使用集合%3给三个玩家发牌，剩余3张牌给底牌
        for (int i = 0; i < arrayList.size(); i++) {
            //获取
            String p = arrayList.get(i);
            //轮流发牌
            if (i >= 51) {
                //给底牌
                dipai.add(p);
            } else if (i % 3 == 0) {
                //给玩家1
                pai.add(p);
            } else if (i % 3 == 1) {
                //给玩家2
                pai1.add(p);
            } else if (i % 3 == 2) {
                //给玩家3
                pai2.add(p);
            }
        }

        //4.看牌
        System.out.println("1 = " + pai);
        System.out.println("2 = " + pai1);
        System.out.println("3 = " + pai2);
        System.out.println("底牌 = " + dipai);
    }
}
