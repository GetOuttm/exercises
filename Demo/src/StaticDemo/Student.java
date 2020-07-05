package StaticDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:36
 */
public class Student {

    private int ID;
    private String name;
    private int age;
    static String room;

    private static int idcount = 0;//学号计数器，每new一个对象+1

    public String getName() {
        return name;
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

    public Student() {
        idcount++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = ++idcount;
    }
}

