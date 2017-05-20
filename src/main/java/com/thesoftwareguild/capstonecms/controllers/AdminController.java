package com.thesoftwareguild.capstonecms.controllers;

import com.thesoftwareguild.capstonecms.daos.CategoryDao;
import com.thesoftwareguild.capstonecms.daos.TagDao;
import com.thesoftwareguild.capstonecms.dtos.Category;
import com.thesoftwareguild.capstonecms.dtos.Tag;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    CategoryDao categoryDao;
    TagDao tagDao;
    
    @Inject
    public AdminController(CategoryDao categoryDao, TagDao tagDao){
        
        this.categoryDao = categoryDao;
        this.tagDao = tagDao;
        
    }
    
    /*
    ############# Tag Block Start ###########
    ############# add
    ############# show
    ############# deleteTag
     ############# edit
            
    */
    
    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    @ResponseBody
    public Tag add(@Valid @RequestBody Tag tag)   {
        
        Tag addedTag = tagDao.add(tag);
        
        return addedTag;
        
    }
    
    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tag show(@PathVariable Integer tagId)    {
        
        Tag tag = tagDao.get(tagId);
        
        return tag;
        
    }
    
    @RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
    public void deleteTag(@PathVariable Integer tagId)  {
        
        tagDao.remove(tagId);
        
    }
    
    @RequestMapping(value = "/tag/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Tag edit(@RequestBody Tag tag)   {
        
        tagDao.update(tag);
        
        return tag;
        
    }
    /*
    ################ Tag block end ##############
    
    
    ################Category block start #########
    ############# add
    ############# showCategory
    ############# deleteCategory
     ############# edit
    */
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    @ResponseBody
    public Category add(@Valid @RequestBody Category category)   {
        
        Category addedCategory = categoryDao.add(category);
        
        return addedCategory;
        
    }
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category showCategory(@PathVariable Integer categoryId)    {
        
        Category category = categoryDao.get(categoryId);
        
        return category;
        
    }
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable Integer categoryId)  {
        
        categoryDao.remove(categoryId);
        
    }
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Category edit(@RequestBody Category category)   {
        
        categoryDao.update(category);
        
        return category;
        
    }

   

}
