package JDK8.方法引用MethodRefObject.ConstructorMethodReference;

/**
 * 定义一个创建Person对象的接口
 */
@FunctionalInterface
public interface PersonBuilder {
    //定义一个方法，根据传递的姓名创建Person对象，返回
    Person builderPerson(String name);
}
