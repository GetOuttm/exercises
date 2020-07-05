package CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Collections是集合的工具类提供了操作集合的方法
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,4,6,5,4,5);
        System.out.println(list);

        //打乱集合元素
        Collections.shuffle(list);
        System.out.println(list);

        /*
        使用前提
            被排序的集合里面存储的元素必须实现Comparable,重写接口中的方法CompareTo定义的排序规则
         */
        Collections.sort(list);
        System.out.println(list);

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("赵六",18));
        arrayList.add(new Student("李四",12));
        arrayList.add(new Student("王五",18));
        arrayList.add(new Student("张三",56));
        System.out.println(arrayList);

//        this - 参数;升序     反之降序
        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //如果年龄相同按照名字的首字母排序
                int result = o1.getAge()-o2.getAge();
                if (result == 0) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
            //重写比较规则
//            @Override
//            public int compare(Student o1, Student o2) {
//                    按照年龄排序
//                return o1.getAge()-o2.getAge();
//            }
        });
        System.out.println(arrayList);
    }
}
