package ObjectDemo;

public class Equals {

    public static void main(String[] args) {
        Person p1 = new Person("aaa",18);
        Person p2 = new Person("ccc",18);
        Person p3 = new Person("aaa",18);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
    }
}
