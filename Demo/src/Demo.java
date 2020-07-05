public class Demo {

    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "bc";
        String str3 = new String("abc");
        String str4 = str1 + str2;
        String str5 = "abc";
        System.out.println(str4 == str5);
        /**
         * 1.String str="hello";
         * 这种方法创建的字符串，如果内存已经为“hello“字符串分配了内存，那么str就指向“hello”内存对象的地址
         * 2.String str=new String("hello");
         * 这种方法创建的字符串，不管内存有没有为“hello”字符串分配内存，都会在内存中重新分配一个内存区域存放“hello”，然后用str指向它，相当于内存中有两个“hello”只是存放的地址不一样。
         */
        System.out.println(str3 == str5);
        System.out.println(str4 == str3);
    }
}
