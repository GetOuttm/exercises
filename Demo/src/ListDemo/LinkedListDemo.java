package ListDemo;

import java.util.LinkedList;

/**
 * java.util.LinkedList集合  implement list接口
 * 特点：
 *  1.底层是链表结构，增删快，查询慢
 *  2.包含大量操作首尾元素的方法
 *  注意：使用LinkedList特有的方法，不能使用多态
 *
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        System.out.println(linkedList.get(0));

        /*
        - public void addFirst(E e):将指定元素插入此列表的开头。
        - public void addLast(E e):将指定元素添加到此列表的结尾。
        - public void push(E e):将元素推入此列表所表示的堆栈。
         */
        linkedList.addFirst("开头");
        linkedList.addLast("结尾");
        linkedList.push("push");
        System.out.println(linkedList);

        /**
         * - public E getFirst():返回此列表的第一个元素。
         *  - public E getLast():返回此列表的最后一个元素。
         */
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(2));

        /**
         * - public E removeFirst():移除并返回此列表的第一个元素。
         *  - public E removeLast():移除并返回此列表的最后一个元素。
         *  - public E pop():从此列表所表示的堆栈处弹出一个元素。  还是0号元素
         */
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        linkedList.clear();
        System.out.println(linkedList);

        /*
         - public boolean isEmpty()：如果列表不包含元素，则返回true。
         */

        if (!linkedList.isEmpty()){
            linkedList.add("我");
        } else {
            linkedList.add("你");
        }
        System.out.println(linkedList);

    }
}
