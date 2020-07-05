package StringDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:10
 */
public class Demo01 {
    public static void main(String[] args) {
        String str = "dsadsadsadsadsa";

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);

            if (map.containsKey(s)) {
                int count = map.get(s);
                count += 1;
                map.put(s,count);
            } else {
                map.put(s,1);
            }

            //遍历集合
            Set<Character> set = map.keySet();
            for (Character character : set) {
                System.out.println("字符" + character + ",个数为" + map.get(character));
            }

        }
    }
}
