package text;

import com.fasterxml.jackson.databind.ObjectMapper;
import domian.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JackJsonTest {

    //Java对象转换为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(24);
        person.setGender("男");

        //2.创建JackJson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //3.调用方法转换
        /**
         * 转换方法：
         *       writeValue(参数1,obj)
         *              参数1
         *                  File:将obj对象转换为json字符串，并保存到指定的文件中
         *                  Writer:将obj对象转换为json字符串，并将json数据填充到字符输出流中
         *                  OutputStream:将obj对象转换为json字符串，并将json数据填充到字节输出流中
         *       writeValueAsString(str)  将对象转为json字符串
         */
        String json = mapper.writeValueAsString(person);
        //{"name":"张三","age":24,"gender":"男"}
        System.out.println(json);


        //调用writeValue方法   将数据写到G://a.txt文件中
//        mapper.writeValue(new File("G://a.txt"),person);

        //将数据关联到Writer中
        mapper.writeValue(new FileWriter("G://b.txt"),person);
    }

    @Test
    public void test2() throws Exception {
        //1.创建person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(24);
        person.setGender("男");
        person.setBirthday(new Date());

        //转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);//{"name":"张三","age":24,"gender":"男","birthday":1588598461650}

    }

    @Test
    public void test3() throws Exception {
        //1.创建person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(24);
        person.setGender("男");
        person.setBirthday(new Date());

        Person person1 = new Person();
        person1.setName("张三");
        person1.setAge(24);
        person1.setGender("男");
        person1.setBirthday(new Date());


        Person person2 = new Person();
        person2.setName("张三");
        person2.setAge(24);
        person2.setGender("男");
        person2.setBirthday(new Date());

        //创建List集合
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);

        //转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);

    }

    @Test
    public void test4() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("name","李四");
        map.put("age",25);
        map.put("gender","男");

        //转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    //json转换为java对象
    @Test
    public void test5() throws Exception {
        //1.初始化json字符串
        String json = "{\"name\":\"张三\",\"age\":24,\"gender\":\"男\"}";
        //2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3.转换为person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
