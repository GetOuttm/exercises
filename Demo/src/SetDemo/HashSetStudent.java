package SetDemo;

import java.util.HashSet;

public class HashSetStudent {
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(new Student("张三",18));
        hashSet.add(new Student("张三",18));
        hashSet.add(new Student("张三",18));
        hashSet.add(new Student("张三",19));

        //如果想让重复的信息存储到集合中可以不重写hashcode
        System.out.println(hashSet);
    }
}
