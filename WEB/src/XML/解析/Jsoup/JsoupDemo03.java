package XML.解析.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document/Element对象功能
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path = JsoupDemo03.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象
        //3.1获取所有的student对象
        Elements student = document.getElementsByTag("student");
        System.out.println(student);

        System.out.println("----------------------------");
        //3.2获取属性名为id的元素对象们
        Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);
        //3.3获取number属性值为heima_0001的元素对象
        System.out.println("---------------------");
        Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elementsByAttributeValue);

        System.out.println("-----------------------");
        //获取id属性值的对象
        Element elementById = document.getElementById("1");
        System.out.println(elementById);
    }
}
