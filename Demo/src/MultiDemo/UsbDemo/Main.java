package MultiDemo.UsbDemo;

public class Main {
    public static void main(String[] args) {
        NoteBook noteBook = new NoteBook();
        noteBook.powerOn();

        Mouse mouse = new Mouse();
        //向上转型
        USB usb = new Mouse();
        noteBook.usbDeive(usb);

        KeyBoard keyBoard = new KeyBoard();
        noteBook.usbDeive(keyBoard);
        noteBook.usbDeive(new KeyBoard());

        noteBook.powerOff();
    }
}
