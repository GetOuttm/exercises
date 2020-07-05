package XML.解析.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath
 */
public class JsoupDemo06 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1获取student.xml的path
        String path = JsoupDemo06.class.getClassLoader().getResource("student.xml").getPath();
        //2获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

       //3根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4结合XPath的语法进行查询
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------------");
        //查询student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------------");

        //查询student标签下的带有id属性的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------------");

        //查询student标签下的带有id属性的name标签,并且id属性值为1
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='1']");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
    }
}
