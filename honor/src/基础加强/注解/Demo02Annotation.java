package 基础加强.注解;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK中预定义的一些注解
 *  1.限定父类重写方法:@Override
 *  2.标示已过时:@Deprecated
 *  3.抑制编译器警告:@SuppressWarnings  一般传递参数all
 *  4.“堆污染”警告与@SafeVarargs
 *  5.函数式接口与@Functionallnterface
 */
@SuppressWarnings("all")
public class Demo02Annotation {

    //1
    @Override
    public String toString(){
        return super.toString();
    }

    //2
    @Deprecated
    public void show1(){
        //有缺陷
    }
    //3

    public void show2(){
        //替换show1
    }
    public void demo(){
        show1();
    }

}
