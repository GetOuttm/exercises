package 泛型Demo;

public class MyClass {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("姓名");
        System.out.println(student.getName());

        Student<Integer> student1 = new Student<>();
        student1.setName(123);
        System.out.println(student1.getName());
    }
}
