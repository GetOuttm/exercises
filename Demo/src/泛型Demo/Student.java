package 泛型Demo;

/**
 * 定义含有泛型的类
 */
public class Student<E>{

    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
