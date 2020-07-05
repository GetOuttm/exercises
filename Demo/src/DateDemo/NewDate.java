package DateDemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;

public class NewDate {
    public static void main(String[] args) {
        /*
        因为java.util.Date月份是0开始的，一月是0.十二月是11
           java.util.LocalDate月份和星期都改成了enum，就不用在用错了

        java.util.Date和SimpleDateFormat都不是线程安全的。
        而LocalDate和LocalTime和最基本的String一样，是不变类型，不但线程安全，而且不能修改

        java.util.Date是一个“万能接口”，它包含日期，时间还有毫秒数，如果你只想用java.util.Date存储日期。
        或者存储时间，那么，只有你知道那部分的数据使有用的，哪些部分的数据是不能用的。
        在新的java 8中，日期和时间被明确划分为LocalDate和LocalTime，LocalDate无法包含时间，LocalTime无法包含日期。
        当然LocalDateTime才能同时包含日期和时间。
        */
        //当前时间
        LocalDate date = LocalDate.now();
        System.out.println(date);
        //指定时间
        LocalDate of = LocalDate.of(2019,12,21);
        System.out.println(of);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }
}
