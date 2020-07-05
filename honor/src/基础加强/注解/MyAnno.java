package 基础加强.注解;

public @interface MyAnno {

    /**
     * 注解的属性  接口中的抽象方法
     * 要求  1.属性的返回值类型(基本数据类型。字符串。枚举，注解。以上类型的数组)
     *      2.定义了属性，在使用时需要给属性赋值
     *          如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时可以不赋值
     *          如果只有一个属性需要复制，属性名称是value，可以直接定义值
     *          数组赋值时间，使用大括号包裹，如果数组中只有一个值可以省略
     *
     * 元注解：用于描述注解的注解
     *      @Target描述作用的位置
     *      @Retention描述被保留的阶段
     *      @Documented描述注解是否被抽取到api文档中
     *      @Inherited描述注解是否被子类继承
     *      @Result同一个程序元素前使用多个相同类型的注解
     * @return
     */
    int age();
    String name() default "张三";

    Person pro();

    MyAnno1 show3();

    String[] strs();
    /*public String show();



    MyAnno1 show3();

    String[]show4();*/
}
