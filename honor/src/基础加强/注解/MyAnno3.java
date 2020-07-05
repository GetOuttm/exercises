package 基础加强.注解;

import java.lang.annotation.*;

/**
 * @Target描述作用的位置
 *      TYPE  可以作用在类上
 *      METHOD  可以作用在方法上
 *      FIELD   可以作用在成员变量上
 * @Retention描述被保留的阶段
 * @Documented描述注解是否被抽取到api文档中
 * @Inherited描述注解是否被子类继承
 */

@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})//表达只能作用在类上
@Retention(RetentionPolicy.RUNTIME)//当前被描述的注解会保留到class字节码文件中并被jvm读取到
@Documented
@Inherited
public @interface MyAnno3 {
}
