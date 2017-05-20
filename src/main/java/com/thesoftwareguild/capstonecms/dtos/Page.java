package com.thesoftwareguild.capstonecms.dtos;

import java.time.LocalDate;
import org.hibernate.validator.constraints.NotEmpty;



public class Page {
    
    private Integer id;
    @NotEmpty(message="Please write a title for your page.")
    private String title;
    @NotEmpty(message="The page's content can not be empty.")
    private String content;
    private LocalDate created;
    private boolean isPublished;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public boolean isIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }
    
    

   

}
