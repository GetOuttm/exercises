package FileAndIO.序列化流;

import java.io.Serializable;

/**
 * 序列化和反序列化的时候会抛出NotSerializableException没有序列化异常
 * 类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化
 * Serializable接口也叫标记型接口
 *      需要机型序列化和反序列化的类必须实现Serializable接口，给类做一个标记
 *      当我们进行序列化和反序列化的时候就会检测类上是否有此标记，有的话就可以序列化和反序列化
 *      没有就会抛出NotSerializableException异常
 *
 *
 *  static关键字：静态关键字
 *     静态优先于非静态加载到内存中(静态优先于对象存入到内存中)
 *     被static修饰的成员变量不能被序列化，序列化的都是对象
 *  transient关键字:瞬态关键字
 *     被transient修饰的成员变量不能被序列化
 */
public class Person implements Serializable {

    /*
    序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联，
    该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类。
    如果接收者加载的该对象的类的 serialVersionUID 与对应的发送者的类的版本号不同，
    则反序列化将会导致 InvalidClassException。可序列化类可以通过声明名为 "serialVersionUID" 的字段
    （该字段必须是静态 (static)、最终 (final) 的 long 型字段）显式声明其自己的 serialVersionUID：
     */
    static final long serialVersionUID = 1234561154;

    private String name;
    //private transient int age;
    //private static int age;
//    public int age;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
