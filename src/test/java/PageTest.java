//
//import com.thesoftwareguild.capstonecms.daos.PageDao;
//import com.thesoftwareguild.capstonecms.daos.CategoryDao;
//import com.thesoftwareguild.capstonecms.daos.PostDao;
//import com.thesoftwareguild.capstonecms.daos.TagDao;
//import com.thesoftwareguild.capstonecms.daos.FileUploadDao;
//import com.thesoftwareguild.capstonecms.dtos.Page;
//import com.thesoftwareguild.capstonecms.dtos.Category;
//import com.thesoftwareguild.capstonecms.dtos.Post;
//import com.thesoftwareguild.capstonecms.dtos.Tag;
//import com.thesoftwareguild.capstonecms.dtos.FileUpload;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * THIS IS THE PAGE (STATIC PAGE, AS OPPOSED TO POST/BLOG) JUNIT CLASS. COPY
// * THIS CLASS, CHANGE THE NAME, AND CALL YOUR DAO TO TEST YOUR METHODS.
// *
// */
//public class PageTest {//CHANGE CLASS NAME
//
//    private PageDao pageDao;
//    private CategoryDao categoryDao;
//    private FileUploadDao fileUploadDao;
//    private TagDao tagDao;
//    private PostDao postDao;
//    
//    Page pageToBeTested = new Page();//CHANGE THIS FOR YOUR DTO OBJECT
//    Page addedPage = null;
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//
//    public PageTest() {//CREATE YOUR OWN TEST NAME
//        this.pageDao = ctx.getBean("pageDao", PageDao.class);
//        this.categoryDao = ctx.getBean("categoryDao", CategoryDao.class);
//        this.fileUploadDao = ctx.getBean("fileDao", FileUploadDao.class);
//        this.tagDao = ctx.getBean("tagDao", TagDao.class);
//        this.postDao = ctx.getBean("postDao", PostDao.class);
//
//    }
//
//    @Before
//    public void setUp() {//SETUP BY IMPORTING INFO TO YOUR OBJECCT
//
//        pageToBeTested.setContent("Content Test");
//        pageToBeTested.setTitle("Title Test");
//        pageToBeTested.setIsPublished(false);
//        addedPage = pageDao.add(pageToBeTested);//ADD OBJECT
//
//    }
//
//    @After
//    public void tearDown() {
//        //PAT SAYS DELETE YOUR SCHEME HERE
//    }
//
//    @Test
//    public void testPageTitleCreation() {
//        String expected = "Title Test";
//        Page fetchPage = pageDao.get(addedPage.getId());
//        String title = fetchPage.getTitle();
//
//        assertEquals(expected, title);
//    }
//
//    @Test
//    public void testPageContentCreation() {
//        String expected = "Content Test";
//        Page fetchPage = pageDao.get(addedPage.getId());
//        String content = fetchPage.getContent();
//
//        assertEquals(expected, content);
//    }
//}
