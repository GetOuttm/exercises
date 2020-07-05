package JDBC.JDBCTemplate;

import JDBC.DBCP.utils.JDBCUtils;
import JDBC.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 需求：
 * 			1. 修改1号数据的 salary 为 10000
 * 			2. 添加一条记录
 * 			3. 删除刚才添加的记录
 * 			4. 查询id为1的记录，将其封装为Map集合
 * 			5. 查询所有记录，将其封装为List
 * 			6. 查询所有记录，将其封装为Emp对象的List集合
 * 			7. 查询总记录数
 */
public class JDBCTemplateDemo02 {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    //1. 修改1号数据的 salary 为 10000
    @Test
    public void testUpdate() {
        String sql = "update emp set salary = 10000 where id = ?";
        int update = jdbcTemplate.update(sql, 1001);
        System.out.println(update);
    }

    //2. 添加一条记录
    @Test
    public void testInsert() {
        String sql = "insert into emp (id,ename,dept_id)values(?,?,?);";
        int count = jdbcTemplate.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    //3.删除刚才添加的记录
    @Test
    public void testDelete() {
        String sql = "delete from emp where id =?;";
        int count = jdbcTemplate.update(sql, 1015);
        System.out.println(count);
    }

    //4. 查询id为1001的记录，将其封装为Map集合
    //这个方法查询的结果长度只能是1
    @Test
    public void testMap() {
        String sql = "select * from emp where id = ? ;";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1001);
        System.out.println(map);
    }

    //5. 查询所有记录，将其封装为List
    @Test
    public void testList() {
        String sql = "select * from emp;";
        List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> list : lists) {
            System.out.println(list);
        }
    }

    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void testEmpList() {
        String sql = "select * from emp;";
        List<Emp> lists = jdbcTemplate.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });
        for (Emp list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void testEmpList1() {
        String sql = "select * from emp;";
        List<Emp> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }



    //7. 查询总记录数
    @Test
    public void testCount() {
        String sql = "select count(id) from emp;";
        Long total = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(total);
    }

}
