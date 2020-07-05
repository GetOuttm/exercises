package com.springproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理:
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *      基于接口的动态地阿里
         *      基于子类的动态代理
         *  基于子类的动态代理
         *      涉及的类：Enhancer
         *      提供者：第三方cglib版本库
         *  如何创建代理对象：使用Enhancer类中的create方法
         *  创建代理对象的要求：被代理类不能是最终类
         *  create的参数：
         *      Class         字节码
         *          它用于指定被代理对象的字节码
         *      Callback callback      用于提供增强的代码
         *           他让我们写入和代理对象，我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但是不是必须的
         *           此接口的实现类是谁用谁写
         *           我们一般写的都是该接口的子接口实现类，MethodInterceptor
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             *  @param proxy     代理对象的引用
             *  @param method    当前执行的方法
             *  @param args      当前执行方法所需的参数
             *           以上三个参数和基于接口的动态代理中invoke方法的参数是一样的
             *  @param methodProxy  当前执行方法的代理对象
             *  @return 和被代理对象有相同的返回值
             *  @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;
                //1.获取方法执行的参数
                Float money = (Float) args[0];
                //2.判断当前方法是否销售
                if ("saleProducer".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        producer.saleProducer(1000F);
    }
}
