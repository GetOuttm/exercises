package com.ljf.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        /**
         * 1.当前类的字节码   Resources.class
         * 2.获取字节码的类加载器    getClassLoader()
         * 3.根据类加载器读取配置  getResourceAsStream(filePath);
         */
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
