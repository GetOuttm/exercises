package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Set;

public class JsoupTest1 {

    /**
     * 解析url
     * @throws Exception
     */
    @Test
    public void testUrl() throws Exception {
        //解析url地址，第一参数是访问的url，第二个参数是访问时候的超时时间,单位毫秒
        Document document = Jsoup.parse(new URL("http://www.itcast.cn/"), 1000);

        //使用标签选择器，获取title标签的内容
        String title = document.getElementsByTag("title").first().text();

        //打印
        System.out.println(title);
    }

    @Test
    public void testString() throws Exception {
        //使用工具类读取文件获取字符串
        String content = FileUtils.readFileToString(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\workspace\\test.html"),
                "utf-8");

        //解析字符串
        String title = Jsoup.parse(content).getElementsByTag("title").first().text();
        System.out.println(title);
    }

    @Test
    public void testFile() throws Exception {
        //解析文件
        Document document = Jsoup.parse(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\workspace\\test.html"),
                "utf8");
        String title = document.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    /**
     * 使用DOM的方式获取元素
     * @throws Exception
     */
    @Test
    public void testDOM() throws Exception {
        //解析文件。获取Document对象
        Document document = Jsoup.parse(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\workspace\\test.html"),
                "utf-8");

        //获取元素
        //1.根据id查询元素getElementById
        Element element = document.getElementById("city_bj");
        //2.根据标签获取元素getElementsByTag
        Element element1 = document.getElementsByTag("span").first();
        //3.根据class获取元素getElementsByClass
        Element element2 = document.getElementsByClass("class_a class_b").first();
        //4.根据属性获取元素getElementsByAttribute
        Element element3 = document.getElementsByAttribute("abc").first();

        Element href = document.getElementsByAttributeValue("href", "http://sh.itcast.cn").first();

        System.out.println(element.text());
        System.out.println(element1.text());
        System.out.println(element2.text());
        System.out.println(document.getElementsByClass("class_a").first().text());
        System.out.println(document.getElementsByClass("class_b").first().text());
        System.out.println(element3.text());
        System.out.println(href.text());
    }

    /**
     * 从元素中获取数据
     * @throws Exception
     */
    @Test
    public void testData() throws Exception {
        //解析文件，获取Document
        Document document = Jsoup.parse(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\workspace\\test.html"),
                "utf-8");
        //根据id获取元素
        Element element = document.getElementById("test");

        //元素中获取数据
        //1.从元素中获取id
        String str = element.id();
        //2.从元素中获取className
        String str1 = element.className();
        Set<String> classNames = element.classNames();
        for (String className : classNames) {
            System.out.println(className);
        }
        //3.从元素中获取属性的值attr
        String str3 = element.attr("id");
        //4.从元素中获取所有属性attributes
        Attributes attributes = element.attributes();
        //5.从元素中获取文本内容text
        String str4 = element.text();

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str3);
        System.out.println(attributes.toString());
        System.out.println(str4);
    }

    /**
     * Selector选择器
     * @throws Exception
     */
    @Test
    public void testSelector() throws Exception {
        //解析文件，获取Document
        Document document = Jsoup.parse(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\workspace\\test.html"),
                "utf-8");

        //tagname: 通过标签查找元素，比如：span
        Elements elements = document.select("span");
        for (Element element : elements) {
            System.out.println(element.text());
        }
        //#id: 通过ID查找元素，比如：# city_bj
        Elements elements1 = document.select("#city_bj");
        System.out.println(elements1.first().text());
        //.class: 通过class名称查找元素，比如：.class_a
        Elements elements2 = document.select(".class_a");
        System.out.println(elements2.first().text());
        // [attribute]: 利用属性查找元素，比如：[abc]
        Elements elements3 = document.select("[abc]");
        System.out.println(elements3.first().text());
        //[attr=value]: 利用属性值来查找元素，比如：[class=s_name]
        Elements elements4 = document.select("[class=s_name]");
        for (Element element : elements4) {
            System.out.println(element.text());
        }
    }

    /**
     * Selector选择器组合使用
     * @throws Exception
     */
    @Test
    public void testSelector1() throws Exception {
        //解析文件，获取Document
        Document document = Jsoup.parse(new File("G:\\java高级课程\\阶段4 流行框架\\资料\\crawler\\workspace\\test.html"),
                "utf-8");

        //el#id: 元素+ID，比如： h3#city_bj
        Element element = document.select("h3#city_bj").first();
        System.out.println(element.text());
        System.out.println("---------------------------------");
        //el.class: 元素+class，比如： li.class_a
        Element element1 = document.select("li.class_a").first();
        System.out.println(element1.text());
        System.out.println("---------------------------------");
        //el[attr]: 元素+属性名，比如： span[abc]
        Element element2 = document.select("span[abc]").first();
        System.out.println(element2.text());
        System.out.println("---------------------------------");
        // 任意组合: 比如：span[abc].s_name
        Element element3 = document.select("span[abc].s_name").first();
        System.out.println(element3.text());
        System.out.println("---------------------------------");
        //ancestor child: 查找某个元素下子元素，比如：.city_con li 查找"city_con"下的所有li
        Elements elements = document.select(".city_con li");
        for (Element element4 : elements) {
            System.out.println(element4.text());
        }
        System.out.println("---------------------------------");
        //parent > child: 查找某个父元素下的直接子元素，比如：
        //.city_con > ul > li 查找city_con第一级（直接子元素）的ul，再找所有ul下的第一级li
        Elements elements2 = document.select(".city_con > ul > li");
        for (Element element4 : elements2) {
            System.out.println(element4.text());
        }
        System.out.println("---------------------------------");
        //parent > *: 查找某个父元素下所有直接子元素
        Elements elements1 = document.select(".city_con > ul > *");
        for (Element element4 : elements1) {
            System.out.println(element4.text());
        }
        System.out.println("---------------------------------");
    }
}
