package Servlet.Filter.Proxy;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println(money + "买了一台电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
