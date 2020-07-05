package dao.impl;

import dao.ProvinceDao;
import domian.Province;
import jedis.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量  JdbcTemplate
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //2.定义sql
        String sql = "select * from province";

        //执行sql
        List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Province.class));

        return list;
    }
}
