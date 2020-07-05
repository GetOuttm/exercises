package XML.解析.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup对象功能
 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path = JsoupDemo02.class.getClassLoader().getResource("student.xml").getPath();
        /*System.out.println(path);*/
        //2.2解析xml文件，加载到内存中，获取dom树--->Documnet
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);

        //parse(String html)  解析xml或html字符串
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!-- \n" +
                "\t1.填写xml文档的根元素\n" +
                "\t2.引入xsi前缀.  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "\t3.引入xsd文件命名空间.  xsi:schemaLocation=\"http://www.itcast.cn/xml  student.xsd\"\n" +
                "\t4.为每一个xsd约束声明一个前缀,作为标识  xmlns=\"http://www.itcast.cn/xml\" \n" +
                "\t\n" +
                "\t\n" +
                " -->\n" +
                " <students>\n" +
                " \t<student number=\"heima_0001\">\n" +
                " \t\t<name>tom</name>\n" +
                " \t\t<age>18</age>\n" +
                " \t\t<sex>male</sex>\n" +
                " \t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                " </students>";
        System.out.println(Jsoup.parse(str));

        //parse(URL url,int timeoutMillis)通过网络路径获取指定的xml或html文档对象
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//代表网络资源的一个路径

        Document parse = Jsoup.parse(url, 10000);
        System.err.println(parse);

    }
}
