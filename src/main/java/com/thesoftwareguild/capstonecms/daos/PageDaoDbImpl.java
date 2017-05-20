package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.Page;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class PageDaoDbImpl implements PageDao {
    
    private JdbcTemplate template;
    
    private static final String SQL_GET_PAGE = "SELECT * FROM holiday.pages WHERE id = ?;";
    private static final String SQL_INSERT_PAGE = "INSERT INTO holiday.pages (`title`, `content`, `is_published`) VALUES (?,?,?);";
    private static final String SQL_REMOVE_PAGE = "DELETE FROM holiday.pages WHERE id = ?";
    private static final String SQL_UPDATE_PAGE = "UPDATE holiday.pages SET title = ?, content = ?, is_published = ?, WHERE id = ?";
    private static final String SQL_LIST = "SELECT * FROM holiday.pages";
    private static final String SQL_SEARCH = "SELECT * FROM holiday.pages WHERE `title` LIKE CONCAT('%',?,'%')";
    

   @Inject
    public PageDaoDbImpl(JdbcTemplate template)    {
        
        this.template = template; 
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Page add(Page page)  {
        template.update(SQL_INSERT_PAGE,
                page.getTitle(),
                page.getContent(),
                page.isIsPublished());
        Integer newId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        page.setId(newId);
        return page;
    }
    
    
    @Override
    public Page get(Integer id) {
        
        Page page = template.queryForObject(SQL_GET_PAGE, new PageMapper(), id);
        
        return page;
    }
    
    @Override
    public void remove(Integer id)  {
        
        template.update(SQL_REMOVE_PAGE, id);
        
    }
    
    @Override
    public void update(Page page)   {
        template.update(SQL_UPDATE_PAGE,
                page.getTitle(),
                page.getContent(),
                page.isIsPublished());
        
    }
    
    @Override
    public List<Page> list()    {
        
        List<Page> pages = template.query(SQL_LIST, new PageMapper());
        
        
        return pages;       
        
        
    }
    
    @Override
    public List<Page> search(String search) {
        
       List<Page> pages = template.query(SQL_SEARCH, new PageMapper(), search);
    return pages;
    }
   

    private static class PageMapper implements RowMapper<Page> {

        public PageMapper() {
        }

        @Override
        public Page mapRow(ResultSet rs, int i) throws SQLException {
            
            Page page = new Page();
            
            page.setId(rs.getInt("id"));
            page.setTitle(rs.getString("title"));
            page.setContent(rs.getString("content"));
            page.setIsPublished(rs.getBoolean("is_published"));
            
            return page;
            
        }
    }

}