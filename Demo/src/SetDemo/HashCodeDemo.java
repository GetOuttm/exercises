package SetDemo;

/**
 * 哈希值：是一个十进制的整数，由系统随机给出(就是对象的地址值，是一个逻辑地址，是模拟出来得到的地址，不是根据数据实际存储的物理地址)
 * 在Object中有一个方法可以获取对象的哈希值
 * int hashCode()
 *           返回该对象的哈希码值。
 *
 * 源码”：
 *  public native int hashCode();
 *  native：代表该方法调用的本地操作系统的方法
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        Person person = new Person();
        int i = person.hashCode();
        System.out.println(i);
        Person person1 = new Person();
        int j = person1.hashCode();
        System.out.println(j);

        /*
        toString的源码
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
         */
        System.out.println(person.toString());
        System.out.println(person);
        System.out.println(person == person1);

        /**
         * Sting类的哈希值
         *      String类重写了Object的HashCode方法
         */
        String str1 = new String("aaa");
        String str2 = new String("aaa");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        //以下哈希值相同
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}
