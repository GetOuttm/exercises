import org.apache.commons.io.FileUtils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

public class LuceneTwo {

    @Test
    public  void createIndex() throws Exception {

        //1.创建Director对象，指定索引保存的位置
        //把索引库保存到内存中
//        Directory directory = new RAMDirectory();
        //把索引库保存到磁盘中
        Directory directory = FSDirectory.open(new File("D:\\Lucene\\index").toPath());
        //2.基于Director对象创建一个IndexWriter对象
        IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig());
        //3.读取磁盘中的文件，对应每个文件创建一个文档对象
        File dir = new File("G:\\java高级课程\\阶段4 流行框架\\资料\\01.Lucene\\lucene\\02.参考资料\\searchsource");
        File[] files = dir.listFiles();
        for (File file : files) {
            //取文件名
            String fileName= file.getName();
            //文件路径
            String filePath = file.getPath();
            //文件内容
            String fileContent = FileUtils.readFileToString(file, "utf-8");
            //文件大小
            long fileSize = FileUtils.sizeOf(file);
            //创建Field
            /**
             * 参数1：域的名称
             * 参数2：域的内容也就是域的值
             * 参数3：是否存储
             */
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
            Field fieldSize = new TextField("size", fileSize + "", Field.Store.YES);
            //创建文档对象
            Document document = new Document();
            //4.向文档对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            document.add(fieldSize);

            //5.把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        //6.关闭IndexWriter对象
        indexWriter.close();
    }

    //改造   在代码中使用中文分析器
    @Test
    public  void createIndex1() throws Exception {

        //1.创建Director对象，指定索引保存的位置
        //把索引库保存到内存中
//        Directory directory = new RAMDirectory();
        //把索引库保存到磁盘中
        Directory directory = FSDirectory.open(new File("D:\\Lucene\\index").toPath());
        //2.基于Director对象创建一个IndexWriter对象
        IndexWriterConfig config = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory,config);
        //3.读取磁盘中的文件，对应每个文件创建一个文档对象
        File dir = new File("G:\\java高级课程\\阶段4 流行框架\\资料\\01.Lucene\\lucene\\02.参考资料\\searchsource");
        File[] files = dir.listFiles();
        for (File file : files) {
            //取文件名
            String fileName= file.getName();
            //文件路径
            String filePath = file.getPath();
            //文件内容
            String fileContent = FileUtils.readFileToString(file, "utf-8");
            //文件大小
            long fileSize = FileUtils.sizeOf(file);
            //创建Field
            /**
             * 参数1：域的名称
             * 参数2：域的内容也就是域的值
             * 参数3：是否存储
             */
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
            Field fieldSize = new TextField("size", fileSize + "", Field.Store.YES);
            //创建文档对象
            Document document = new Document();
            //4.向文档对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            document.add(fieldSize);

            //5.把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        //6.关闭IndexWriter对象
        indexWriter.close();
    }

    //改造   用正确的field存储数据
    @Test
    public  void createIndex2() throws Exception {
        //1.创建Director对象，指定索引保存的位置
        //把索引库保存到内存中
//        Directory directory = new RAMDirectory();
        //把索引库保存到磁盘中
        Directory directory = FSDirectory.open(new File("D:\\Lucene\\index").toPath());
        //2.基于Director对象创建一个IndexWriter对象
        IndexWriterConfig config = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory,config);
        //3.读取磁盘中的文件，对应每个文件创建一个文档对象
        File dir = new File("G:\\java高级课程\\阶段4 流行框架\\资料\\01.Lucene\\lucene\\02.参考资料\\searchsource");
        File[] files = dir.listFiles();
        for (File file : files) {
            //取文件名
            String fileName= file.getName();
            //文件路径
            String filePath = file.getPath();
            //文件内容
            String fileContent = FileUtils.readFileToString(file, "utf-8");
            //文件大小
            long fileSize = FileUtils.sizeOf(file);
            //创建Field
            /**
             * 参数1：域的名称
             * 参数2：域的内容也就是域的值
             * 参数3：是否存储
             */
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
            Field fieldPath = new StoredField("path", filePath);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
            Field fieldSizeValue = new LongPoint("size", fileSize);//存储值  只存储值是查不到的
            Field fieldSizeStore = new StoredField("size",fileSize);//存储
            //创建文档对象
            Document document = new Document();
            //4.向文档对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            document.add(fieldSizeValue);
            document.add(fieldSizeStore);

            //5.把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        //6.关闭IndexWriter对象
        indexWriter.close();
    }

    @Test
    public void searchIndex() throws Exception {
        //1.创建Director对象，指定索引保存的位置
        Directory directory = FSDirectory.open(new File("D:\\Lucene\\index").toPath());
        //2.基于Director对象创建一个IndexReader对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //3.创建IndexSearcher对象，构造方法中的参数indexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4.创建Query对象，TermQuery
        Query query = new TermQuery(new Term("name","spring"));
        //5.执行查询，得到TopDocs对象
        //参数1：查询对象  查询2：查询结果返回的最大记录数
        TopDocs topDocs = indexSearcher.search(query, 10);
        //6.取得查询结果的总记录数
        System.out.println("总记录数：" + topDocs.totalHits);
        //7.取文档列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        //8.打印文档中的内容
        for (ScoreDoc scoreDoc : scoreDocs) {
            //取文档id
            int docId = scoreDoc.doc;
            //根据id从取文档对象
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
//            System.out.println(document.get("content"));
            System.out.println(document.get("size"));
            System.out.println("====================");
        }
        //9.关闭IndexReader对象
        indexReader.close();
    }

    @Test
    public void TokenStream() throws Exception {
//        1创建一个Analyzer对象。StandardAnalyzer 对象
        Analyzer analyzer = new StandardAnalyzer();
//        2使用分析其的tokenStream方法获取TokenStream对象
        TokenStream tokenStream = analyzer.tokenStream("", "Learn how to create a web page with Spring MVC.");
//        3向tokenStream对象中设置一个引用，相当于一个指针
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
//        4调用tokenStream对象的方法rest方法，如果不调用抛异常
        tokenStream.reset();
//        5使用while循环遍历tokenStream对象
        while (tokenStream.incrementToken()) {
            System.out.println(charTermAttribute);
        }
//        6关闭tokenStream对象
        tokenStream.close();
    }

    @Test
    public void testIKAnalyzer() throws Exception {
//        1创建一个Analyzer对象。StandardAnalyzer 对象
        Analyzer analyzer = new IKAnalyzer();
//        2使用分析其的tokenStream方法获取TokenStream对象
        TokenStream tokenStream = analyzer.tokenStream("", "百度黑马传智播客公安局1\t什么是全文检索java \n" +
                "1.1\t全文检索概式或有限长构化数据（如关系型数据库、面向对象数据库中的数据）和完全无结构的数据（如声音、图像文件等）之间的数据，HTML、XML文档就属于半结构化数据，数据的结构和内容混在一起，没有明显的区分。\n");
//        3向tokenStream对象中设置一个引用，相当于一个指针
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
//        4调用tokenStream对象的方法rest方法，如果不调用抛异常
        tokenStream.reset();
//        5使用while循环遍历tokenStream对象
        while (tokenStream.incrementToken()) {
            System.out.println(charTermAttribute);
        }
//        6关闭tokenStream对象
        tokenStream.close();
    }

}
