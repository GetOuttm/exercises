package XML.解析.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * selector:选择器查询
 */
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {
        //1获取student.xml的path
        String path = JsoupDemo05.class.getClassLoader().getResource("student.xml").getPath();
        //2获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //查询name标签
        Elements elements = document.select("name");
        System.out.println(elements.size());
        System.out.println(elements);
        System.out.println("-----------------------------------------");

        //查询id值为1的元素
        Elements select = document.select("#1");
        System.out.println(select);
        System.out.println("-----------------------------------------");

        //获取student标签并且number属性值为heima_0001的age子标签
        //获取student标签并且number属性值为heima_0001
        Elements select1 = document.select("student[number='heima_0001']");
        System.out.println(select1);
        System.out.println("-----------------------------------------");
        //获取age子标签
        Elements select2 = document.select("student[number='heima_0001'] > age");
        System.out.println(select2);
    }
}
