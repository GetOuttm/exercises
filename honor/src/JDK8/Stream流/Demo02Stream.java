package JDK8.Stream流;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Stream流的方式，遍历集合，对集合的数据进行过滤
 */
public class Demo02Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream().filter(name->name.startsWith("张"))
                .filter(name->name.length() == 3)
                .forEach(name-> System.out.println(name));
    }
}
