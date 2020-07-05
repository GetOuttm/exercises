package 包装类;

/**
 * 基本数据类型           包装类
 *  boolean             Boolean
 *  byte                Byte
 *  char                Character
 *  short               Short
 *  int                 Integer
 *  float               Float
 *  double              Double
 *  long                Long
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * 构造方法
         * Integer(int value)
         *           构造一个新分配的 Integer 对象，它表示指定的 int 值。
         * Integer(String s)
         *           构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
         *
         * 静态方法
         * static String toString(int i)
         *           返回一个表示指定整数的 String 对象。
         * static String toString(int i, int radix)
         *           返回用第二个参数指定基数表示的第一个参数的字符串表示形式。
         * static Integer valueOf(int i)
         *           返回一个表示指定的 int 值的 Integer 实例。
         * static Integer valueOf(String s)
         *           返回保存指定的 String 的值的 Integer 对象。
         * static Integer valueOf(String s, int radix)
         *           返回一个 Integer 对象，该对象中保存了用第二个参数提供的基数进行解析时从指定的 String 中提取的值。
         */

        Integer integer = new Integer(123);
        System.out.println(integer);
        Integer integer1 = new Integer("12");
        System.out.println(integer1);

        String string = integer.toString(123);
        System.out.println(string);
        Integer integer2 = Integer.valueOf(123456);
        System.out.println(integer2);

        /*
        拆箱
         */
        int i = integer2.intValue();
        System.out.println(i);


        //自动拆装箱
        Integer integer3 = 333;
        int in = new Integer(integer3);


        //基本类型与字符串进行转换
        String s = "" + 12;
        //包装类的静态方法
        Integer a = 123456789;
        String string1 = Integer.toString(a);

        //字符串转基本类型
        int i1 = Integer.parseInt(s);
        System.out.println(i1);
    }
}
