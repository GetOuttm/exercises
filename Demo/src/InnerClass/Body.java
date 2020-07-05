package InnerClass;

/**
 * 使用内部类的方法
 * 1.间接使用：在外部类的方法当中使用内部类，然后main方法调用外部类的方法
 * 2.直接使用：
 *      公式：外部类名称.内部类名称  对象名 = new 内部类名称().内部类名称();
 */
public class Body {//外部类

    class Hert{//成员内部类

        //内部类方法
        public void beat(){
            System.out.println("心脏跳动");

            System.out.println(name);
        }
    }

    //外部类的成员变量
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void method(){
        System.out.println("外部类的方法");
        Hert hert = new Hert();
        hert.beat();
    }
}
