package AbstractDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 18:47
 */
public class User {

    private String name;

    private int price;

    public void show() {
        System.out.println("我叫" + name + "，我有" + price + "钱。");
    }

    public User() {
    }

    public User(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
