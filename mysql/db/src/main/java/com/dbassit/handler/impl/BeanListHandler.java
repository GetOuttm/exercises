package com.dbassit.handler.impl;

import com.dbassit.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 结果集封装的具体实现类
 * 此类实现的是把一个结果及集ResultSet的内容封装到一个指定的实体类对象中
 *
 * 使用要求：
 *      实体类中属性必须和表中的列名一致(sql语句查询出来的列名一致)
 * @param
 */
public class BeanListHandler implements ResultSetHandler {
    private Class domainClass;

    public BeanListHandler(Class domainClass) {
        this.domainClass = domainClass;
    }

    /**
     * 把resultSet的内容封装到domainClass所表示的类中
     * @param resultSet
     * @return
     */
    public Object handler(ResultSet resultSet) {
        try {
            List list = new ArrayList();
            //2.判断是否有结果集
            while (resultSet.next()) {
                //1.创建一个对象
                Object bean = domainClass.newInstance();
                //3.得到结果集所有的列名
                //要想得到列名，先得到结果集的源信息
                ResultSetMetaData metaData = resultSet.getMetaData();
                //得到源信息之后还要得到多少列
                int count = metaData.getColumnCount();
                //遍历列数
                for (int i = 0; i < count; i++) {
                    //得到每列名称
                    String columnName = metaData.getColumnName(i + 1);
                    //列名其实就是实体类的属性名称，于是就可以使用列名得到实体类z中属性的描述器
                    PropertyDescriptor pd = new PropertyDescriptor(columnName,domainClass);//实体类中定义的私有类成员和get set方法
                    //获取属性的写入方法(set)
                    Method method = pd.getWriteMethod();
                    //获取当前列名所对应的值
                    Object columnValue = resultSet.getObject(columnName);
                    //通过执行写方法把得到的值给属性赋上
                    method.invoke(bean,columnValue);

                }
                //把封装好的对象加入到list
                list.add(bean);
            }
            //3.返回
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
