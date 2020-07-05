package web.servlet;

public class demo {
    public static void main(String[] args) {
        String str = "123";
        String str1 = null;

        if (str=="123"){
            System.out.println("str true");
        }else{
            System.out.println("str false");
        }
        if ("123" == str) {
            System.out.println("str true");
        } else {
            System.out.println("str false");
        }
        if (str1 == "123") {
            System.out.println("str1 true");
        }else {
            System.out.println("str1 false");
        }

        if ("123".equals(str)) {
            System.out.println("str true");
        } else {
            System.out.println("str false");
        }
        if (str.equals("123")){
            System.out.println("str true");
        } else {
            System.out.println("str false");
        }


        if ("123".equals(str1)) {
            System.out.println("str1 true");
        }else {
            System.out.println("str1 false");
        }

        /**
         * 常量在前，变量在后可以避免空指针异常
         */
        if (str1.equals("123")) {
            System.out.println("str1 true");
        }else {
            System.out.println("str1 false");
        }
    }
}
