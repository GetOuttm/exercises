package 基础加强.反射;

import 基础加强.反射.doMan.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 案例
 *  需求：写一个框架，可以帮我们创建任意类的对象，并且执行任意方法
 *        不能改变该类的任意代码
 *  假设框架会自己执行
 *
 *  实现：1.配置文件   2.反射
 *  步骤：
 *      1.将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 *      2.在程序中加载读取配置文件
 *      3.使用反射加载类文件到内存
 *      4.创建对象
 *      5.执行方法
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        //创建Properties对象
        Properties properties = new Properties();
        //转换为集合
        ClassLoader classLoader = Demo05.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        //获取数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //进内存
        Class<?> aClass = Class.forName(className);

        //创建对象
        Object o = aClass.newInstance();
        //执行方法
        Method method = aClass.getMethod(methodName);

        method.invoke(o);
    }
}
