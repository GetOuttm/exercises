package MultiDemo.UsbDemo;

/***
 * 电脑类
 */
public class NoteBook {

    //开机
    public void powerOn(){
        System.out.println("电脑打开");
    }
    //关机
    public void powerOff(){
        System.out.println("电脑关机");
    }

    //使用功能
    public void usbDeive(USB usb) {
        usb.on();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.type();
        } else if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.type();
        }

        usb.off();
    }
}
