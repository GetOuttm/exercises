package JDK8.Stream流.获取流的方式;

public class Dmeo09Person {
    private String name;

    public Dmeo09Person() {
    }

    public Dmeo09Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dmeo09Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
