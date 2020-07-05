package 基础加强.注解;

import java.lang.reflect.Method;

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
@Pro(className = "基础加强.注解.Demo06",methodName = "show")
public class Demo05 {
    public static void main(String[] args) throws Exception {
        /**
         * 解析注解
         * 获取该类的字节码文件对象
         */
        Class<Demo05> demo05Class = Demo05.class;
        //获取上边的注解对象
        //其实就是在内存中生成的该注解接口的子类实现对象
        /*
            public class ProImpl implements Pro{
                public String className() {return "基础加强.注解.Demo06";}
                public String methodName() {return "show";}
            }
        */
        Pro annotation = demo05Class.getAnnotation(Pro.class);

        //调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //进内存
        Class<?> aClass = Class.forName(className);

        //创建对象
        Object o = aClass.newInstance();
        //执行方法
        Method method = aClass.getMethod(methodName);

        method.invoke(o);
    }
}
