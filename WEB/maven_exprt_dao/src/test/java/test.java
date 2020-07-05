import com.aili.dao.ItemsDao;
import com.aili.domain.Items;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void findById(){
        //先获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从容器中拿到所需的dao代理对象  调用mapper对象
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);

        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());

    }
}
