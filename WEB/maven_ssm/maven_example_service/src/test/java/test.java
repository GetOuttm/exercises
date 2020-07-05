import org.junit.Test;
import com.ljf.domain.Items;
import com.ljf.service.ItemsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void findById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-service.xml");

        ItemsService itemsService = applicationContext.getBean(ItemsService.class);

        Items items = itemsService.findById(1);
        System.out.println(items);

    }
}
