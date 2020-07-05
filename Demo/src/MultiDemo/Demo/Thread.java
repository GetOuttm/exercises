package MultiDemo.Demo;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/16 14:35
 */
public class Thread {
     public static void main(String[] args) {
        //向上造型
        Fu fu = new A();
        fu.work();
        Fu fz = new B();
        fz.work();

        //向下转型
        A as = (A) fu;
        as.workA();
        //java.lang.ClassCastException 编译不会报错，运行会出错
//        B ab = (B) fu;
//        ab.workB();
        B aa = (B) fz;
        aa.workB();


         System.out.println("===========================");
         /**
          * 如何才能知道一个父类引用的对象，本来是什么子类？
          */
         Fu ff = new A();
         ff.work();

         if (ff instanceof B) {
             B w = (B) ff;
             w.workB();
         }

         //如果希望调用子类特有方法，需要向下转型  需要判断
         if (ff instanceof A) {
             A q = (A) ff;
             q.workA();
         }
     }
}
