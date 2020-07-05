import com.aili.dao.ItemsDao;
import com.aili.domain.Items;
import com.aili.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void findByIdDao(){
        //先获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从容器中拿到所需的dao代理对象
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);

        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());
    }


    @Test
    public void findByIdService(){
        //先获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从容器中拿到所需的dao代理对象
        //service测试
        ItemsService itemsService = applicationContext.getBean(ItemsService.class);
        //调用方法
        Items items = itemsService.findById(1);
        System.out.println(items.getName());
    }
}
