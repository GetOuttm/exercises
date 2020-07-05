package XML.解析.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 */
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
        //1获取student.xml的path
        String path = JsoupDemo04.class.getClassLoader().getResource("student.xml").getPath();
        //2获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        /**
         * Element：元素对象
         * 		1. 获取子元素对象
         * 			* getElementById​(String id)：根据id属性值获取唯一的element对象
         * 			* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
         * 			* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
         * 			* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
         *
         * 		2. 获取属性值
         * 			* String attr(String key)：根据属性名称获取属性值
         * 		3. 获取文本内容
         * 			* String text():获取文本内容
         * 			* String html():获取标签体的所有内容(包括子标签的标签和字符串内容)
         */
        //通过document获取name标签，获取所有的name标签
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("-----------------------");
        //通过element对象获取子标签对象
        Element student = document.getElementsByTag("student").get(0);
        Elements name = student.getElementsByTag("name");
        System.out.println(name.size());
        System.out.println("-----------------------");

        //获取student对象的属性值
        String name1 = student.attr("number");
        System.out.println(name1);
        System.out.println("-----------------------");

        //获取文本内容
        String text = name.text();
        String html = name.html();
        System.out.println(text);
        System.out.println(html);

    }
}
