package MultiDemo.UsbDemo;

/**
 * 鼠标类
 */
public class Mouse implements USB {


    @Override
    public void on() {
        System.out.println("打开鼠标");
    }

    @Override
    public void off() {
        System.out.println("关闭鼠标");
    }

    public void type(){
        System.out.println("鼠标点击");
    }
}
