package XML.解析.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文件获取
        //2.1获取student.xml的path
        String path = JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        /*System.out.println(path);*/
        //2.2解析xml文件，加载到内存中，获取dom树--->Documnet
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
        //3.获取元素对象elements
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //3.1获取第一个elements对象
        Element element = elements.get(0);
        //3.2获取数据
        String text = element.text();
        System.out.println(text);
    }
}
