package dao.impl;

import dao.ItemsDao;
import domian.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 要想从数据库中取出数据必须有4个属性
 *      数据区驱动
 *      连接数据库的地址
 *      数据库用户名
 *      数据库密码
 */
public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception {
        List<Items> list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            //先获取contection对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven","root","123");


            //获取操作数据库的对象
            preparedStatement = connection.prepareCall("select * from items");

            //执行
            resultSet = preparedStatement.executeQuery();

            //把数据库结果集转换为java的list集合

            while (resultSet.next()) {
                Items items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                list.add(items);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            resultSet.close();
            preparedStatement.close();
        }

        return list;
    }
}
