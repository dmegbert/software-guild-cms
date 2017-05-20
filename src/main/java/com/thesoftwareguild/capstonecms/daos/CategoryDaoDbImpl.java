package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class CategoryDaoDbImpl implements CategoryDao {
    
    
private JdbcTemplate template;
    
    private static final String SQL_GET_POST = "";
    private static final String SQL_INSERT_POST = "";
    private static final String SQL_REMOVE_POST = "";
    private static final String SQL_UPDATE_POST = "";
    private static final String SQL_LIST = "Select * FROM holiday.categories";
    private static final String SQL_SEARCH = "";
    
   @Inject
    public CategoryDaoDbImpl(JdbcTemplate template)    {
        
        this.template = template; 
        
    }
    
    @Override
    public Category add(Category category)  {
        
        return category;
    }
    
    
    @Override
    public Category get(Integer id) {
        
        Category categoryMade = new Category(); //shitcan this for actual method use jdbc
        
        return categoryMade;
    }
    
    @Override
    public void remove(Integer id)  {
        
    }
    
    @Override
    public void update(Category category)   {
        
    }
    
    @Override
    public List<Category> list()    {
        
        List<Category> categories = template.query(SQL_LIST, new CatMapper());
        
        return categories;       
    }
    
    @Override
    public List<Category> search(String search) {
        
        List<Category> categories = new ArrayList(); //shitcan for actual method
        
        return categories;
        
    }

    private static class CatMapper implements RowMapper<Category> {

        public CatMapper() {
        }

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category cat = new Category();
            
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));
            
            return cat;
        
        }
    }

   

}
