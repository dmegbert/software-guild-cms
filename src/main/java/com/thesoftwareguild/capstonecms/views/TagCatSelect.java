/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.capstonecms.views;

import com.thesoftwareguild.capstonecms.dtos.Category;
import com.thesoftwareguild.capstonecms.dtos.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class TagCatSelect {
    
    private List<Tag> tags;
    private List<Category> category;

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @return the category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }
    
}
