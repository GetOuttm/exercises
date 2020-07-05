package 基础加强.注解;
@MyAnno(age = 12,pro = Person.p1,show3 = @MyAnno1,strs = {"aaa","bbbb"})
@MyAnno3
public class Worker {
    public void show() {

    }
}
