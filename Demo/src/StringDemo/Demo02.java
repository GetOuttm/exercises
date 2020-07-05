package StringDemo;

import java.util.HashMap;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:19
 */
public class Demo02 {
    public static void main(String[] args) {
        print("dsadsadsa12345454黄金时代到合肥库货到付款赋给112211111ASNDSJA");
    }

    public static void print(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            map.put(c, !map.containsKey(c) ? 1 : (map.get(c) + 1));
        }
        for (Character c : map.keySet()) {
            System.out.println(c + ":" + map.get(c));
        }
    }
}