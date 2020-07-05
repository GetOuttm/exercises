import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

/**
 * 索引维护
 */
public class IndexManger {

    private IndexWriter indexWriter;

    @Before
    public void init() throws Exception {
        //创建一个IndexWriter对象，需要使用IKAnalyzer作为分析器
        indexWriter = new IndexWriter(FSDirectory.open(new File("D:\\Lucene\\index").toPath()),
                new IndexWriterConfig(new IKAnalyzer()));
    }

    //添加文档
    @Test
    public void addDocument() throws Exception {

        //创建Document对象
        Document document = new Document();
        //向Document对象中添加域
        document.add(new TextField("name","新添加的文件", Field.Store.YES));
        document.add(new TextField("content","新添加的文件内容", Field.Store.NO));
        document.add(new StoredField("path","d:/Lucene/hello"));

        //吧文档写入索引库
        indexWriter.addDocument(document);

        //关闭索引库
        indexWriter.close();
    }


    //删除索引库
    @Test
    public void delAllDocument() throws Exception {
        //删除索引库
        indexWriter.deleteAll();
        //关闭索引库
        indexWriter.close();
    }

    //删除索引库  针对query删除
    @Test
    public void delDocumentByQuery() throws Exception {
        //删除索引库
        indexWriter.deleteDocuments(new Term("name","apache"));
        //关闭索引库
        indexWriter.close();
    }


    //更新索引库   先删除后添加
    @Test
    public void updateDocument() throws Exception {
        //常见一个新的文档对象
        Document document = new Document();
        //像文档对象中添加域
        document.add(new TextField("name","更新之后的文档", Field.Store.YES));
        document.add(new TextField("name1","更新之后的文档1", Field.Store.YES));
        document.add(new TextField("name2","更新之后的文档2", Field.Store.YES));

        //更新操作
        indexWriter.updateDocument(new Term("name","spring"),document);
        //关闭索引库
        indexWriter.close();
    }
}
