package FileAndIO.递归;

/**
 * 递归求阶乘
 *   阶乘：所有小于及等于该数的正整数的积。
 *   n的阶乘：n! = n * (n‐1) *...* 3 * 2 * 1
 */
public class Demo03 {
    public static void main(String[] args) {
        System.out.println(jc(100000));
    }

    /*
    定义方法使用递归计算阶乘
     */
    public static int jc(int a) {
        if (a == 1) {
            return 1;
        }

        return a * (a - 1);
    }
}
