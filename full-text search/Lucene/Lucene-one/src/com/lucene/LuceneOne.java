package com.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;

public class LuceneOne {

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
            Field fieldSize = new TextField("content", fileSize + "", Field.Store.YES);
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
}
