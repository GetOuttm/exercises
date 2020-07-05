package 基础加强.反射;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import 基础加强.反射.doMan.Person;

import java.lang.reflect.Method;

/**
 * 构造方法 getMethod(String name, 类<?>... parameterTypes)
 *  *      方法[] getMethods()
 *  *
 *  *      方法 getDeclaredMethod(String name, 类<?>... parameterTypes)
 *  *      方法[] getDeclaredMethods()
 */
public class ReflectDem03Method {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());

        }

        Method method = personClass.getMethod("we");
        Person person = new Person();
        method.invoke(person);


        //获取类名
        String name = personClass.getName();
        System.out.println(name);
    }
}
