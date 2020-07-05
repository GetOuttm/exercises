package SetDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * 具有可预知迭代顺序的 Set 接口的哈希表和链接列表实现。此实现与 HashSet 的不同之外在于，
 * 后者维护着一个运行于所有条目的双重链接列表。此链接列表定义了迭代顺序，
 * 即按照将元素插入到 set 中的顺序（插入顺序）进行迭代。注意，插入顺序不 受在 set 中重新插入的 元素的影响。
 * （如果在 s.contains(e) 返回 true 后立即调用 s.add(e)，则元素 e 会被重新插入到 set s 中。）
 *
 * 特点：
 *  1.底层是哈希表(数组+链表+红黑树)+链表
 *  多出来的链表是记录元素的存储顺序，保证元素有序
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("dsa");
        hashSet.add("ss");
        hashSet.add("dfff");
        hashSet.add("ss");
        System.out.println(hashSet);//无序，不可重复

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("dsa");
        linkedHashSet.add("ss");
        linkedHashSet.add("dfff");
        linkedHashSet.add("ss");
        System.out.println(linkedHashSet);//有序。不可重复
    }
}
