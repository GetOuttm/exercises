package com.quick1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @SpringBootApplication与
 * @SpringBootConfiguration    实现配置文件的功能
 * @EnableAutoConfiguration   是否开启自动配置开关
 * @ComponentScan(     组件扫描
 *     excludeFilters = {@Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {TypeExcludeFilter.class}
 * ), @Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {AutoConfigurationExcludeFilter.class}
 * )}
 * )以上三个注解的效果一样
 */
@SpringBootApplication
public class Springboot2QuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2QuickApplication.class, args);
    }

}
