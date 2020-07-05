package 基础加强.反射;

import 基础加强.反射.doMan.Person;

/**
 * 获取Class对象的三种方式
 * 1.Class.forName() 将字节码加载到没存，返回Class对象  多用于配置文件
 * 2.类名.class   通过类名的属性获取Class              多用于参数传递
 * 3.对象.getClass  getClass方法在Object中定义的      多用于对象的获取字节码方式
 *
 * 结论：同一个字节码文件在一次程序运行过程中只会被加载一次
 */
public class ReflectDem01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("基础加强.反射.doMan.Person");
        System.out.println(cls);


        Class personClass = Person.class;
        System.out.println(personClass);

        Class aClass = new Person().getClass();
        System.out.println(aClass);

        System.out.println(cls == personClass);
        System.out.println(personClass == aClass);
    }
}
