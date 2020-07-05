package DateDemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date表示时间和日期
 */
public class Demo01 {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);

        long s = System.currentTimeMillis();//获取当前时间距1970年1月1日 00:00:00有多少毫秒

        long time = date.getTime();
        System.out.println(time);

        /**
         * SimpleDateFormat
         * 非线程安全，SimpleDateFormat转换日期是通过Calendar对象操作的
         * SimpleDateFormat继承DateFormat类，DateFormat类中维持一个Calendar对象
         * 当多线程同时操作就会出现线程安全问题
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String str = sdf.format(date);
        System.out.println(str);

        Date parse = sdf.parse("2019年12月17日 15时26分11秒");
        System.out.println(parse);
    }
}
