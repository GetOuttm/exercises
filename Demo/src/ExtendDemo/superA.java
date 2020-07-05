package ExtendDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 19:41
 */
public class superA {
    int i = 100;
    void fun(int j) {
        j = i;
        System.out.println("This is superA");
    }
}
// 定义superA的子类subB
class subB extends superA {
    int m = 1;
    void fun(int aa) {
        System.out.println("This is subB");
    }
}
// 定义superA的子类subC
class subC extends superA {
    int n = 1;
    void fun(int cc) {
        System.out.println("This is subC");
    }
}
class Test {
    public static void main(String[] args) {
        superA a = new superA();
        subB b = new subB();
        subC c = new subC();
        a = b;
        a.fun(100);
        a = c;
        a.fun(200);
    }
}


/*
 * 上述代码中subB和subC是超类superA的子类,我们在类Test中声明了3个引用变量a, b,
 * c,通过将子类对象引用赋值给超类对象引用变量来实现动态方法调用。也许有人会问：
 * "为什么(1)和(2)不输出：This is superA"。
 * java的这种机制遵循一个原则：当超类对象引用变量引用子类对象时,
 * 被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法,
 * 但是这个被调用的方法必须是在超类中定义过的,
 * 也就是说被子类覆盖的方法。
 * 所以,不要被上例中(1)和(2)所迷惑,虽然写成a.fun(),但是由于(1)中的a被b赋值,
 * 指向了子类subB的一个实例,因而(1)所调用的fun()实际上是子类subB的成员方法fun(),
 * 它覆盖了超类superA的成员方法fun()；同样(2)调用的是子类subC的成员方法fun()。
 * 另外,如果子类继承的超类是一个抽象类,虽然抽象类不能通过new操作符实例化,
 * 但是可以创建抽象类的对象引用指向子类对象,以实现运行时多态性。具体的实现方法同上例。
 * 不过,抽象类的子类必须覆盖实现超类中的所有的抽象方法,
 * 否则子类必须被abstract修饰符修饰,当然也就不能被实例化了
 */