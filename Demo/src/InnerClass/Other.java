package InnerClass;

class Other {

    int num = 10;//外部类的成员变量

    class Inner {
        int num = 20;//内部类的成员变量
        public void method(){
            int num = 30;//内部类的局部变量
            System.out.println(num);//局部变量
            System.out.println(this.num);//成员变量
            //如果出现重名，格式为：外部类名称.this.外部类成员变量
            System.out.println(Other.this.num);//外部类的成员变量
        }
    }


    public void method(){
       class MyClass{//局部内部类
            int num = 40;
            public void method(){
                System.out.println(num);
            }
        }
        MyClass myClass = new MyClass();
        myClass.method();
    }


}
