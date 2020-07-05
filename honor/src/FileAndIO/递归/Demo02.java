package FileAndIO.递归;

/**
 * 练习
 *      使用递归计算1-n之间的和
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    /**
     *  定义一个方法，使用递归计算1-n之间的和
     *  1+2+3+....
     *  n+(n-1)+(n-2)+....+1
     *  已知：
     *    最大值：n
     *    最小值：1
     *  使用递归必须明确：
     *      1：递归的结束条件   获取到1的时候结束
     *      2：递归的目的  获取下一个被加的数字(n-1)
     */
    public static int sum(int a){
        //获取到1的时候结束
        if (a == 1) {
            return 1;
        }

        //获取下一个被加的数字(n-1)
        return a + sum(a-1);
    }
}
