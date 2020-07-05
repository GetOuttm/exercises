package String;

import java.util.ArrayList;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 19:06
 */
public class Demo03 {

    public static void main(String[] args) {
        String str = ";qweqweqweqwe";

        ArrayList<Character> arrayList = new ArrayList<>();
        char[] chars = str.toCharArray();//将字符串转换为字符数组
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            arrayList.add(c);//将字符数组元素添加到集合中
        }
        System.out.println(arrayList);//打印测试

        for (int i = 0; i < arrayList.size(); i++) {//遍历集合取出每个元素
            int count = 0;//定义计数器
            Character character = arrayList.get(i);//;

            for (int j = 0; j < chars.length; j++) {//遍历数组取出每个字符与几个中的元素进行比较
                char c = chars[j];
                if (character.equals(c)) {//如果集合中的元素有，等于数组中的字符，计数器加1

                    count++;
                }
            }
            System.out.println(character + "出现了" + count + "次");
        }

    }
}
