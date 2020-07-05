package 基础加强.反射;

import 基础加强.反射.doMan.Person;

import java.lang.reflect.Constructor;

public class ReflectDemo04Constructor {
    public static void main(String[] args) throws Exception {
        /**获取构造方法
         *       Constructor<T> getConstructor(类<?>... parameterTypes)
        *      Constructor<?>[] getConstructors()
        *
        *      Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
        *      Constructor<?>[] getDeclaredConstructors()
         */
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        Person person = constructor.newInstance("张三", 12);
        System.out.println(person);

        System.out.println("====================");

        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor();
        System.out.println(declaredConstructor);

        Person person1 = declaredConstructor.newInstance();
        System.out.println(person1);
    }
}
