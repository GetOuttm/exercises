package MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *Set EntrySet() 遍历所有k-v
 */
public class EntrySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",123);
        map.put("李四",234);
        map.put("王五",345);
        map.put("赵六",456);
        map.put("田七",567);
        System.out.println(map);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
