package StringBuilderDemo;

public class Demo {

    public static void main(String[] args) {
        //空参构造方法
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.length());

        StringBuilder stringBuilder1 = new StringBuilder("www");
        System.out.println(stringBuilder1);
        System.out.println(stringBuilder1.length());

        StringBuilder append = stringBuilder.append(12.6);
        System.out.println(stringBuilder);
        System.out.println(append);
        System.out.println(stringBuilder == append);


        String str = stringBuilder.toString();
        System.out.println(str);
    }
}
