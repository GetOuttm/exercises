package Lambda.Demo03;

import java.util.ArrayList;

/**
 * Lamdba表达式是可推导，可以省略的
 * 凡是根据上下文推导出来的内容都可以省略书写
 * 可以省略的内容：
 *  1.(参数列表)：括号中参数列表的数据类型可以省略不写
 *  2.(参数列表)：括号中的参数如果只有一个，那么类型和()都可以省略不写
 *  3.(一些代码)：如果{}中的代码只有一行，而且无论是否有返回值都可以省略{}、return、分号
 *      注意：要省略{}、return、分号必须一起省略
 */
public class Demo {

    public static void main(String[] args) {
        //JDK1.7之前 ，创建集合必须把前后的泛型写上
        ArrayList<String> list = new ArrayList<String>();

        //1.7之后，等号右边的泛型可以省略，后边的泛型就是根据前边的泛型推导出来的。
        ArrayList<String> list1 = new ArrayList<>();
    }
}
