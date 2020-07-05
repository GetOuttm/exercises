package JDK8.方法引用MethodRefObject.ConstructorMethodReference;

/**
 * 类的构造器引用  构造器也叫构造方法
 */
public class Test {
    //定义一个方法，参数传递姓名和PersonBuilder接口，方法中通过姓名创建Person对象
    public static void printName(String name, PersonBuilder personBuilder) {
        Person person = personBuilder.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        printName("李锦峰",(name) -> new Person(name));

        //优化
        printName("哇哈哈",Person::new);
    }

}
