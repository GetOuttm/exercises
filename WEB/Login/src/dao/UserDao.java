package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtil;

/**
 * 操作数据库中的USER表
 */
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDateSource());

    /**
     * 登录方式
     * @param user   用户和密码
     * @return  用户全部数据
     */
    public User login(User user){
        try {
            //编写sql
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            User loginUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(), user.getPassword());
            return loginUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
