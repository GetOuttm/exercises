package MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 自定义键值
 */
public class MapStudent {
    public static void main(String[] args) {
        HashMap<String,Student> map = new HashMap<>();
        map.put("one",new Student("张三",19));
        map.put("two",new Student("李四",15));
        map.put("three",new Student("王五",119));
        map.put("one",new Student("赵六",101));
        System.out.println(map);

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s + ":" + map.get(s));
        }
        System.out.println("=============================");


        /**
         * key为Student 那么必须重写equals和hashcode以保证key统一
         */
        HashMap<Student,String> hashMap = new HashMap<>();
        hashMap.put(new Student("饿了么",19),"上海");
        hashMap.put(new Student("支付宝",19),"北京");
        hashMap.put(new Student("闪送",19),"山西");
        hashMap.put(new Student("饿了么",19),"天津");
        System.out.println(hashMap);

        Set<Map.Entry<Student, String>> entries = hashMap.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry);
        }

        Iterator<Map.Entry<Student, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
