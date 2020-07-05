package Servlet.Filter.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        //动态代理增强Lenovo对象
        /**
         * 三个参数
         *      1.类加载器。真实对象.getClass().getClassLoader()
         *      2.接口数组，真实对象.getClass().getInterfaces()
         *      3.处理器，new InvocationHandler()
         */
        SaleComputer saleComputer_lenovo  =
                (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(),

                /**
                 * 代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法执行
                 *
                 * 该方法参数
                 *      1.proxy：代理对象
                 *      2.method：代理对象调用的方法.被封装的对象
                 *      3.args:代理对象调用的方法时，传递的实际参数
                 */
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*System.out.println("该方法执行了");
                        System.out.println(method.getName());
                        System.out.println(args[0]);*/

                        //判断是否是sale方法
                        if (method.getName().equals("sale")) {
                            //1.增强参数
                            double money = (double)args[0];
                            money = money * 0.85;
                            System.out.println("专车接送。。。。");
                            //使用真实对象调用方法
                            String invoke = (String) method.invoke(lenovo, money);
                            System.out.println("免费送货。。。");
                            //2.增强返回值
                            return invoke + "_鼠标垫";
                        } else {
                            //相当于真实对象调用该方法
                            Object invoke = method.invoke(lenovo, args);
                            return invoke;
                        }
                    }
                });

        String sale = saleComputer_lenovo.sale(8000);
        System.out.println(sale);

        saleComputer_lenovo.show();
    }
}
