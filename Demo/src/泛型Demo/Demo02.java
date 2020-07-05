package 泛型Demo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型通配符  ？代表任意类型
 * 不能创建对象使用
 * 只能作为方法的参数使用
 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(13);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("12");
        arrayList2.add("13");

        method(arrayList);
        method(arrayList2);
    }

    /**
     * 定义一个方法能遍历所有类型的ArrayList集合
     * 我们不知道ArrayList集合使用的什么类型
     */
    public static void method(ArrayList<?> arrayList){
        //定义迭代器遍历
        Iterator<?> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
