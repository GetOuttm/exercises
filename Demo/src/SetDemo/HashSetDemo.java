package SetDemo;

import java.util.HashSet;

/**
 *
 *不允许存储重复元素
 * HashSet集合存储数据的结构(哈希表)  特点就是查询速度快  初始容量是16
 * jdk1.8版本之前 哈希表=数组+链表
 * jdk1.8版本之后
 *      哈希表=数组+链表；
 *      哈希表=数组+红黑树(提高查询的速度)
 *      如果链表的长度超过8位，那么就把链表转换为红黑树
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        String str1 = new String("abc");
        String str2 = new String("abc");
        hashSet.add(str1);
        hashSet.add(str2);
        hashSet.add("abc");
        hashSet.add("重地");
        hashSet.add("通话");
        System.out.println(hashSet);
    }
}
