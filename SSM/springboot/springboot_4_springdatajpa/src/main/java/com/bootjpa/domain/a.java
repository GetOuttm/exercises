package com.bootjpa.domain;

import java.math.BigDecimal;

public class a {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.2");
        BigDecimal bigDecimal1 = new BigDecimal("2.3");

        BigDecimal bigDecimal2 = bigDecimal.add(bigDecimal1);
        System.out.println(bigDecimal2);

    }
}
