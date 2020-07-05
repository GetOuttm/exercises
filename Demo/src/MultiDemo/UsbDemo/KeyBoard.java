package MultiDemo.UsbDemo;

/*
键盘类
 */
public class KeyBoard implements USB {
    @Override
    public void on() {
        System.out.println("打开键盘");
    }

    @Override
    public void off() {
        System.out.println("关闭键盘");
    }

    public void type(){
        System.out.println("键盘输入");
    }

}
