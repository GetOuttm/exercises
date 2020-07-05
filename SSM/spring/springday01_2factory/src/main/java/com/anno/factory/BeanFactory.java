package com.anno.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建按bean对象的工厂
 *    bean在计算机语言中，有可重用组件的含义
 *
 * JavaBean:用java语言编写的可重用组件
 *      javabean > 实体类
 *
 *   它就是创建service和dao对象
 *   第一：需要配置文件来配置我们的service和dao
 *          配置内容：唯一标识=全限定类名（key=value）
 *   第二：通过读取配置文件中的内容 反射创建对象
 *
 *      配置文件可以是xml或者是properties
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties properties;
    //定义一个map用于存放我们创建的对象，我们把它称之为容易
    private static Map<String,Object> beans;

    /**
     * 读取bean.properties配置文件
     */
    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(is);

            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每一个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    //根据bean的名称获取bean对象     单例
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /**
     * 根据bean的名称获取bean对象     多例
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
            System.out.println(beanPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
