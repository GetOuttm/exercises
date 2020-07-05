package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 19:05
 */
//查询字符出现的次数
public class Demo01 {

    public static void main(String[] args) {
        String str = "dhdhdhdhdhdhdhdhdhdh我单杀绝对时空观就爱看户籍改革和开放的";

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);

            /**
             * )如果此映射包含指定键的映射关系，则返回 true。更确切地讲，
             * 当且仅当此映射包含针对满足 (key==null ? k==null : key.equals(k)) 的键 k 的映射关系时，
             * 返回 true。（最多只能有一个这样的映射关系）。
             *
             * 看map中是否已经包含这个key
             */
            if (map.containsKey(s)) {
                int count = map.get(s);
                count += 1;
                map.put(s,count);
            } else {
                map.put(s,1);
            }
        }
        Set<Character> set = map.keySet();
        for (Character character : set) {
            System.out.println("字符：" + character + ",个数为" + map.get(character));
        }
    }

}
