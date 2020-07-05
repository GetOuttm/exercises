package JDK8.方法引用MethodRefObject.SupperMethodReference;
//子类
public class Man extends Human {
    //子类重写sayHello方法

    @Override
    public void sayHello() {
        System.out.println("Hello,我是Man");
    }

    //定义一个方法，参数传递Greetable接口
    public void method(Greetable greetable){
        greetable.greet();
    }

    //调用method方法，方法的参数Greetable是函数式接口，可以传递Lambda表达式
    public void show() {
        method(() -> {
            //创建父类Human对象
            Human h = new Human();
            h.sayHello();
        });
        //因为有子父类关系，所以存在一个关键字supper代表父类，我们可以直接使用supper调用父类的方法
        method(() -> super.sayHello());

        //优化，supper引用父类的成员方法
        method(super::sayHello);

    }

    public static void main(String[] args) {
        new Man().show();
    }
}
