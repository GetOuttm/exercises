package MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Set keySet()
 * 将当前map中所有的key以一个set集合的形式返回.遍历集合相当于遍历所有的key
 */
public class KeySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",123);
        map.put("李四",234);
        map.put("王五",345);
        map.put("赵六",456);
        map.put("田七",567);
        System.out.println(map);

        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key + ":" + value);
        }


        for (String string : strings) {
            System.out.println(string + ":" + map.get(string));
        }
    }
}
