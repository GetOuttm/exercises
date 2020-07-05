package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username,
                    password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO user values (null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),
                user.getQq(),user.getEmail());
    }

    @Override
    public void delUser(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        template.update(sql,id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user SET name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? " +
                "WHERE id = ?";

        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),
                user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public int findTotalCount(Map<String ,String[]> map) {
        //定义模板sql
        String sql = "SELECT count(*) FROM user WHERE 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历map
        Set<String> set = map.keySet();
        //定义参数的集合
        ArrayList<Object> params = new ArrayList<Object>();

        for (String key : set) {
                //排除分页
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = map.get(key)[0];
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" AND " + key + " LIKE ? ");
                params.add("%" + value + "%");//加？条件的值
            }
        }
        System.err.println(stringBuilder.toString());
        System.err.println(params);

        return template.queryForObject(stringBuilder.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String ,String[]> map) {
        String sql = "SELECT * FROM user WHERE 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历map
        Set<String> set = map.keySet();
        //定义参数的集合
        ArrayList<Object> params = new ArrayList<Object>();

        for (String key : set) {
            //排除分页
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = map.get(key)[0];
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" AND " + key + " LIKE ? ");
                params.add("%" + value + "%");//加？条件的值
            }
        }

        //添加分页查询
        stringBuilder.append(" LIMIT ?,? ");
        //添加分页参数
        params.add(start);
        params.add(rows);
        sql = stringBuilder.toString();
        System.out.println(sql);
        System.out.println(params);
        return template.query(sql,new BeanPropertyRowMapper<>(User.class),params.toArray());
    }


}
