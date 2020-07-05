package MapDemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * 继承自HashMap
 * Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序。
 * 底层原理
 *  哈希表+链表(记录元素的顺序)
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();
        hashMap.put("b","bbbbb");
        hashMap.put("a","aaaa");
        hashMap.put("c","ccccc");
        hashMap.put("a","dddd");
        System.out.println(hashMap);

        HashMap<String,String> map = new HashMap<>();
        map.put("b","bbbbb");
        map.put("a","aaaa");
        map.put("c","ccccc");
        map.put("a","dddd");
        System.out.println(map);
    }
}
