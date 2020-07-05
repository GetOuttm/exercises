package MapDemo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 计算一个字符串中字符出现的次数
 */
public class CountDemo {
    public static void main(String[] args) {
        String str = "ababababawqewqfdsfdsjkkcjzxjfdsj;dslafdshjkafhdsadj;sfhdsa北京";
        method(str);
    }

    public static void method(String str) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (hashMap.containsKey(c)) {
                Integer in = hashMap.get(c);
                in++;
                hashMap.put(c,in);
            } else {
                hashMap.put(c,1);
            }
        }
        System.out.println(hashMap);

        for (Character character : hashMap.keySet()) {
            System.out.println(character + ":" + hashMap.get(character));
        }
    }
}
