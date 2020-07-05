package com.mvc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换为日期
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * @param s  传入字符串
     * @return
     */
    @Override
    public Date convert(String s) {
        //判断
        if (s == null) {
            throw new RuntimeException("请您传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //字符串转换为日期
        try {
            return dateFormat.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
