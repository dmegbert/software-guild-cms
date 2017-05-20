package com.thesoftwareguild.capstonecms.controllers;

import com.thesoftwareguild.capstonecms.daos.CategoryDao;
import com.thesoftwareguild.capstonecms.daos.PostDao;
import com.thesoftwareguild.capstonecms.daos.TagDao;
import com.thesoftwareguild.capstonecms.dtos.Category;
import com.thesoftwareguild.capstonecms.dtos.CommandPost;
import com.thesoftwareguild.capstonecms.dtos.Post;
import com.thesoftwareguild.capstonecms.dtos.Tag;
import com.thesoftwareguild.capstonecms.views.TagCatSelect;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    private PostDao postDao;
    private CategoryDao catDao;
    private TagDao tagDao;

    @Inject
    public PostController(PostDao postDao, CategoryDao catDao, TagDao tagDao) {
        this.postDao = postDao;
        this.catDao = catDao;
        this.tagDao = tagDao;

    }

    @RequestMapping(value = "/add")
    public String addPost(Model model) {

        List<Category> cats = catDao.list();
        List<Tag> tags = tagDao.list();

        model.addAttribute("cats", cats);
        model.addAttribute("tags", tags);

        return "addpost";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Post add(@Valid @RequestBody CommandPost post) {

        CommandPost aPost = post;

        Post addedPost = postDao.add(post);

        return addedPost;

    }

    @RequestMapping(value = "/select")
    @ResponseBody
    public TagCatSelect getTagsCats() {

        TagCatSelect tagsCats = new TagCatSelect();

        List<Tag> tags = tagDao.list();
        List<Category> cats = catDao.list();
        tagsCats.setTags(tags);
        tagsCats.setCategory(cats);

        return tagsCats;

    }

    @RequestMapping(value="/showedit/{id}")
    public String showedit(@PathVariable("id") Integer postId, Model model) {
        
        Post post = postDao.get(postId);
        List<Tag> tags = post.getTags();
        
        model.addAttribute("post", post);
        model.addAttribute("tags", tags);
        
        return "editpost";
        
    }
    
    

    @RequestMapping(value = "/{id}")
    public String show(@PathVariable("id") Integer postId, Model model) {

        Post post = postDao.get(postId);
        List<Tag> tags = post.getTags();

        model.addAttribute("post", post);
        model.addAttribute("tags", tags);

        return "showpost";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") Integer postId) {

        postDao.remove(postId);

    }

    
    @RequestMapping(value="", method = RequestMethod.PUT)
    @ResponseBody
    public Post edit(@Valid @RequestBody CommandPost post){
        
      CommandPost aPost = post;
        
      Post editedPost = postDao.update(post);
        

       return editedPost;
        
    }

    @RequestMapping(value = "/all")
    public String list(Model model){

        List<Post> posts = postDao.list();
        model.addAttribute("allposts", posts);
        
        return "showallpost";

    }

}
