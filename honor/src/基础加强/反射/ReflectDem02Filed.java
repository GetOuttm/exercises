package 基础加强.反射;

import 基础加强.反射.doMan.Person;

import java.lang.reflect.Field;

/**
 * Class对象的功能：
 * 获取功能：
 *  1.获取成员变量
 *      Field getField(String name)
 *      Field[] getFields()    获取public修饰的
 *
 *      Field getDeclaredField(String name)
 *      Field[] getDeclaredFields()
 *  2.获取成员方法
 *      方法 getMethod(String name, 类<?>... parameterTypes)
 *      方法[] getMethods()
 *
 *      方法 getDeclaredMethod(String name, 类<?>... parameterTypes)
 *      方法[] getDeclaredMethods()
 *  3.获取构造方法
 *      Constructor<T> getConstructor(类<?>... parameterTypes)
 *      Constructor<?>[] getConstructors()
 *
 *      Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 *      Constructor<?>[] getDeclaredConstructors()
 *  4.获取类名
 *       String getName()
 *
 */
public class ReflectDem02Filed {
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //获取成员变量
        Field[] fields = Person.class.getFields();
        int length = fields.length;
        System.out.println(length);
        Field a = personClass.getField("a");
        Person person = new Person();
        Object o = a.get(person);
        System.out.println(o);
        a.set(person,111);
        System.out.println(person);

        System.out.println("===========================");

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Field value = personClass.getDeclaredField("name");

        //忽略访问权限修饰符的安全检查
        value.setAccessible(true);//暴力反射
        System.out.println(value.get(person));
    }
}
