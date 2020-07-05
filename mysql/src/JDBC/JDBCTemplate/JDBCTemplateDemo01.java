package JDBC.JDBCTemplate;

import JDBC.DBCP.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBCTemplate入门
 */
public class JDBCTemplateDemo01 {
    public static void main(String[] args) {
        //导入jar包
        //创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int update = jdbcTemplate.update(sql, 5);
        System.out.println(update);
    }
}
