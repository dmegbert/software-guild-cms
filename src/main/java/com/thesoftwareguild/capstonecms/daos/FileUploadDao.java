package com.thesoftwareguild.capstonecms.daos;


import com.thesoftwareguild.capstonecms.dtos.FileUpload;
//import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class FileUploadDao {
    
    private JdbcTemplate template;
    
    private static final String SQL_INSERT_FILE = "INSERT INTO `uploads` (`file_bytes`, `file_extension`, `file_name`) VALUES (?, ?, ?);";
    private static final String SQL_GET_FILE = "SELECT * from `uploads` WHERE id = ?";
    private static final String SQL_GET_LIST = "SELECT * from `uploads`;";
    private static final String SQL_DELETE_FILE = "DELETE from `uploads` WHERE id = ?";
    
    
    @Inject
    public FileUploadDao(JdbcTemplate template) {
        
        this.template = template;
        
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public FileUpload add(FileUpload file)  {
        
        template.update(SQL_INSERT_FILE, 
                file.getFileByte(),
                file.getExtensionType(),
                file.getFileName());
        
        Integer newId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        file.setId(newId);
        
        return file;
    }
    
    public FileUpload get(Integer id)   {
        
        FileUpload file = template.queryForObject(SQL_GET_FILE, new FileUploadMapper(), id);
        
        return file;
        
    }
    
    public List<FileUpload> list()  {
        
        List<FileUpload> files = template.query(SQL_GET_LIST, new FileUploadMapper());
        
        return files;
        
        
    }

    public void delete(Integer id) {
    
        template.update(SQL_DELETE_FILE, id);
    
    
    }

    private class FileUploadMapper implements RowMapper<FileUpload>{

        public FileUploadMapper() {
        }

        @Override
        public FileUpload mapRow(ResultSet rs, int i) throws SQLException {
        
        FileUpload file = new FileUpload();
        
        file.setId(rs.getInt("id"));
        file.setFileByte(rs.getBytes("file_bytes"));
        file.setExtensionType(rs.getString("file_extension"));
        file.setFileName(rs.getString("file_name"));
        
        
        return file;
        
        }
    }

   

}
