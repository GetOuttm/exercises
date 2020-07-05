package Lambda.Demo01;

import java.util.Arrays;
import java.util.Comparator;

public class Demp {
    public static void main(String[] args) {
        Person[] arr = {
            new Person("张三",22),
                new Person("李四",19),
            new Person("王五",20)
        };


        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });


        for (Person person : arr) {
            System.out.println(person);
        }
        System.out.println("================");


        //Lamdba表达式
        Arrays.sort(arr, (Person o1, Person o2) -> {
                return o1.getAge() - o2.getAge();
        });

        //优化
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());

        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
