package Throwable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse("1996-03-18");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }
}
