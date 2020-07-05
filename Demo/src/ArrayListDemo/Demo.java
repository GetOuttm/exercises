package ArrayListDemo;

import java.util.ArrayList;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 10:35
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        /*
        直接打印不是地址值。如果内容为空那么打印为[]
         */
        System.out.println(arrayList);

        arrayList.add("dsadsa");
        arrayList.add("三天");
        arrayList.add("三天");
        arrayList.add("三天");
        arrayList.add("三天");
        arrayList.add("三天");
        System.out.println(arrayList);

        arrayList.remove(0);
        System.out.println(arrayList);

        System.out.println(arrayList.size());
    }
}
