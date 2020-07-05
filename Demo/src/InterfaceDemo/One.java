package InterfaceDemo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/15 19:20
 */
public interface One {
    public default void one(){
        System.out.println("默认方法2");
    }
}
