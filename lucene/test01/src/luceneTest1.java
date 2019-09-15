import org.apache.commons.io.FileUtils;

import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class luceneTest1 {
    @Test
    public void creatInddex() throws Exception {
//1、创建一个Director对象，指定索引库保存的位置
        Directory directory = FSDirectory.open(new File("D:\\temp\\index").toPath());
//2、基于Directory对象创建一个IndexWriter对象
        IndexWriterConfig config = new IndexWriterConfig();
        IndexWriter indexWriter = new IndexWriter(directory, config);
//3、读取磁盘上的文件，对应每个文件创建一个文档对象。
        File dir = new File("D:\\code\\java就业班\\lucene_git_eclipse\\lucene\\02.参考资料");
        File[] files = dir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            String filePath = file.getPath();
            String fileContent = FileUtils.readFileToString(file);
            long fileSize  = FileUtils.sizeOf(file);
            //4、向文档对象中添加域
//            TextField fileNameField = new TextField("filename", fileName, Field.Store.YES);
            Field fileNameField = new TextField("filename", fileName, Field.Store.YES);
        }
        System.out.println("22222");



//5、把文档对象写入索引库

//6、关闭indexwriter对象

    }
}
