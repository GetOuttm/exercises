package com.di.service.impl;

import com.di.service.AccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Map<String,String> myMap;
    private Properties properties;


    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(properties);
    }
}
