import org.junit.Test;
import com.ljf.dao.ItemsDao;
import com.ljf.domain.Items;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void findById(){
        //先获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

        //从容器中拿到所需的dao代理对象  调用mapper对象
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);

        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());

    }
}
