package MapDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util接口 Map<K,V>
 *  类型参数：
 *      K - 此映射所维护的键的类型
 *      V - 映射值的类型
 *      key(不允许重复,有且只有一个null)，value可以为null
 */
public class Demo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,null);
        map.put(null,"789");
        map.put("asd",null);
        map.put("1","123");
        map.put("2","123");
        map.put("3","123");
        System.out.println(map);

        //根据k获取对应的value
        System.out.println(map.get(null));

        //根据给定的k删除与之对应的v
        System.out.println(map.remove("1"));
        System.out.println(map);

        //判断当前mao是否包含给定的k或v
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("123"));

    }
}
