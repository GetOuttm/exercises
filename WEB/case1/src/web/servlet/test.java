package web.servlet;

public class test {

    public static void main(String[] args) {
        try {
            ClassLoader.getSystemClassLoader().loadClass("org.ljf.web.servlet.ClassForname");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
