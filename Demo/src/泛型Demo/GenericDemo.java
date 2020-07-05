package 泛型Demo;

public class GenericDemo {
    public static void main(String[] args) {
        Generic generic = new Generic();
        generic.method(123);
        generic.method("wqewq");

        generic.mthod("静态方法，不建议创建对象使用");
        //通过类名点
        Generic.mthod("123");

    }



}
