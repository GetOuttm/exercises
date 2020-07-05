package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 19:05
 */
public class Demo02 {

    public static void main(String[] args) {
        String str = "ljdsajhjdhfsgdsf;kldhsahfdsa";
        print(str);
    }

    public static void print(String str) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        System.out.println(chars);

        for (char aChar : chars) {
            map.put(aChar,!map.containsKey(aChar) ? 1 : (map.get(aChar) + 1));
        }

        for (Character character : map.keySet()) {
            System.out.println(character + "个数为：" + map.get(character));
        }
    }
}
