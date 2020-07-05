package 斗地主.Two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
有序
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        //创建牌的索引
        ArrayList<Integer> list = new ArrayList<>();
        String[] colors = {"♣","♥","♦","♠"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        int index = 0;
        hashMap.put(index,"大王");
        list.add(index);
        index++;
        hashMap.put(index,"小王");
        list.add(index);
        index++;
        //循环组装52张牌
        for (String number : numbers) {
            for (String color : colors) {
                hashMap.put(index,color + number);
                list.add(index);
                index++;
            }
        }
        System.out.println(hashMap);
        System.out.println(list);


        //洗牌
        Collections.shuffle(list);
        System.out.println(list);


        //3.发牌
        //定义4个集合。存储玩家的牌和底牌
        ArrayList<Integer> pai = new ArrayList<>();
        ArrayList<Integer> pai1 = new ArrayList<>();
        ArrayList<Integer> pai2 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer in = list.get(i);
            //轮流发牌
            if (i >= 51) {
                //给底牌
                dipai.add(in);
            } else if (i % 3 == 0) {
                //给玩家1
                pai.add(in);
            } else if (i % 3 == 1) {
                //给玩家2
                pai1.add(in);
            } else if (i % 3 == 2) {
                //给玩家3
                pai2.add(in);
            }
        }

        Collections.sort(pai);
        Collections.sort(pai1);
        Collections.sort(pai2);
        Collections.sort(dipai);

        //看牌
        method("张三",hashMap,pai);
        method("李四",hashMap,pai1);
        method("王五",hashMap,pai2);
        method("底牌",hashMap,dipai);
    }

    public static void method(String name,HashMap<Integer,String> hashMap,
                              ArrayList<Integer> list){
        System.out.print(name + "=    ");
        for (Integer key : list) {
            System.out.print(hashMap.get(key) + "  ");
        }
        System.out.println();
    }
}
