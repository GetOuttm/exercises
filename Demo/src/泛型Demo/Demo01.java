package 泛型Demo;

public class Demo01 {
    public static void main(String[] args) {
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.method("123");

        GenericInterfaceImpl01 genericInterfaceImpl01 = new GenericInterfaceImpl01();
        genericInterfaceImpl01.method(12);
        genericInterfaceImpl01.method("dsadsa");
    }
}
