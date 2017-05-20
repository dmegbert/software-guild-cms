package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class TagDaoDbImpl implements TagDao {
    
        
private JdbcTemplate template;
    
    private static final String SQL_GET_POST = "";
    private static final String SQL_INSERT_POST = "";
    private static final String SQL_REMOVE_POST = "";
    private static final String SQL_UPDATE_POST = "";
    private static final String SQL_LIST = "Select * from holiday.tags";
    private static final String SQL_SEARCH = "";
    
    

   @Inject
    public TagDaoDbImpl(JdbcTemplate template)    {
        
        this.template = template;
        
        
    }
    
    @Override
    public Tag add(Tag tag)  {
        
        return tag;
    }
    
    
    @Override
    public Tag get(Integer id) {
        
        Tag tagMade = new Tag(); //shitcan this for actual method use jdbc
        
        return tagMade;
    }
    
    @Override
    public void remove(Integer id)  {
        
        
    }
    
    @Override
    public void update(Tag tag)   {
        
        
    }
    
    @Override
    public List<Tag> list()    {
        
        List<Tag> tags = template.query(SQL_LIST, new tagsMapper());
        
        
        return tags;       
        
        
    }
    
    @Override
    public List<Tag> search(String search) {
        
        List<Tag> tags = new ArrayList(); //shitcan for actual method
        
        return tags;
        
    }

    private static class tagsMapper implements RowMapper<Tag> {

        public tagsMapper() {
        }

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            
            tag.setId(rs.getInt("id"));
            tag.setName(rs.getString("name"));
            
            return tag;
        
        }

    }

   

}
