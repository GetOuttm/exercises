package JDBC.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回
 */
public class JdbcDemo {

    public static void main(String[] args) {
        List<Emp> all = new JdbcDemo().findAll();
        System.out.println(all);
        System.out.println(all.size());
    }

    /**
     * 查询所有emp对象
     * @return
     */
    public List<Emp> findAll() {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        List<Emp> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
            //3.定义SQL
            String sql = "SELECT * FROM emp;";
            //4.获取执行sql对象
            statement = connection.createStatement();
            //5.执行sql
            resultSet = statement.executeQuery(sql);
            //6.遍历结果集，封装对象，装在集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (resultSet.next()) {
                //获取数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");
                resultSet.getInt("mgr");
                //创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
