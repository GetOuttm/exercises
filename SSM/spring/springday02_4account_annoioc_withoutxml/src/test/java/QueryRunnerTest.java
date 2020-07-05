import config.SpringConfig;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner是否是单例的
 */
public class QueryRunnerTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取QueryRunner对象
        QueryRunner runner = context.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = context.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
