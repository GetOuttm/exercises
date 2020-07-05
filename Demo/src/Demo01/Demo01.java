package Demo01;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/12 18:52
 */
public class Demo01 {

    public static void main(String[] args) {
        Student student = new Student();

        student.setAge(18);
        student.setName("李锦峰");

        String src = student.toString();
        System.out.println(src);

        Student student1 = new Student("zhangsan",20);
        System.out.println("姓名：" + student1.getName() + "年龄" + student1.getAge());
    }
}
