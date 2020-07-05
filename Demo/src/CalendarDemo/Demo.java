package CalendarDemo;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历类是一个抽象类
 */
public class Demo {
    public static void main(String[] args) {
        Calendar str = Calendar.getInstance();
        System.out.println(str);

        //转换为Date
        Date date = str.getTime();
        System.out.println(date);

        //获取当前字段的值
        System.out.println(str.get(Calendar.YEAR));

        //返回此字段的最大值
        System.out.println(str.getActualMaximum(Calendar.MAY));

        //设置某常量加多少或者减多少
        str.add(Calendar.YEAR,12);
        System.out.println(str.get(Calendar.YEAR));

        //设置某个常量为固定值
        str.set(Calendar.YEAR,999);
        System.out.println(str.get(Calendar.YEAR));
    }
}
