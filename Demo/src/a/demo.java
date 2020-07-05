package a;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1");
        BigDecimal bigDecimal1 = new BigDecimal(2).valueOf(2);
        int i = bigDecimal.compareTo(bigDecimal1);
        System.out.println(i);


        List<Object> list = new ArrayList<>(3);
        Map<String,Integer> map = new HashMap(3);

        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        for (Object o : list) {
            System.out.println(o);
        }


        String s = "0.1";
        String s1 = "0.1";
        int i1 = s.compareTo(s1);
        System.out.println(i1);


    }
}
