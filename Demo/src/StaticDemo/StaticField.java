package StaticDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 12:38
 */
public class StaticField {

    public static void main(String[] args) {
        Student one = new Student("张三",12);
        Student two = new Student("李四",23);
        one.room = "第三";//相当于是Student.room,所以two.room也是Student.room

        System.out.println("学号" + one.getID() + "姓名" + one.getName() + "年龄" + one.getAge() + "教室"
                 + one.room);
        System.out.println("学号" + two.getID() +"姓名" + two.getName() + "年龄" + two.getAge() + "教室" + two.room);
    }
}
