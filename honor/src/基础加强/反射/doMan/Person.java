package 基础加强.反射.doMan;

public class Person {
    private String name;
    private int age;

    public int a;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                '}';
    }

    public String getName() {
        return name;
    }

    public void we() {
        System.out.println("ssssss");
    }

    public void eat() {
        System.out.println("eat....");
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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
