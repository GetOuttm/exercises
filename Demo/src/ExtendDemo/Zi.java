package ExtendDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/13 16:01
 */
public class Zi extends Fu {

    int numZi = 20;

    int num = 200;

    public void methodNum(){
        int nuber = 2000;
        System.out.println(nuber);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
