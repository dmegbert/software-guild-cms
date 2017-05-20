//
//import com.thesoftwareguild.capstonecms.daos.FileUploadDao;
//import com.thesoftwareguild.capstonecms.dtos.FileUpload;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.List;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// *
// * @author apprentice
// */
//public class UploadTest {
//
//    private FileUploadDao fileUploadDao;
//
//    private FileUpload fileUpload;
//
//    ApplicationContext ctx;
//
//    public UploadTest() {
//
//        ctx = new ClassPathXmlApplicationContext("test-applicationContext_1.xml");
//        this.fileUploadDao = ctx.getBean("fileDao", FileUploadDao.class);
//
//    }
//
//    @Before
//    public void setUp() {
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void hello() {
//        String hello = "hello"; //Test just to see that setup is not throwing exceptions or the project doesn't need to clean and build.
//
//        Assert.assertEquals("hello", hello);
//    }
//
//    @Test
//    public void addTest() throws IOException {
//
//        fileUpload = new FileUpload();
//
//        fileUpload.setFileByte(Files.readAllBytes(new File("/home/apprentice/Pictures/pittsburgh.jpg").toPath()));
//
//        fileUpload.setExtensionType("image/jpeg");
//        fileUpload.setFileName("Pittsburgh");
//        fileUpload.setId(fileUploadDao.add(fileUpload).getId());
//
//        Assert.assertEquals(fileUpload, fileUpload);
//    }
//
//    @Test
//    public void getTest() {
//
//        fileUpload = fileUploadDao.get(1);
//
//        Assert.assertSame(fileUpload.getFileName(), fileUpload.getFileName());
//
//    }
//
//    @Test
//    public void listTest() {
//
//        List<FileUpload> fileList = fileUploadDao.list();
//
//        Assert.assertSame(fileUploadDao.list().size(), fileList.size());
//
//    }
//}
