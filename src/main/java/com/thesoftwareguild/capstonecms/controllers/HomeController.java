package com.thesoftwareguild.capstonecms.controllers;

import com.thesoftwareguild.capstonecms.daos.PostDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    
    PostDao postDao;
    
    @Inject
    public HomeController(PostDao postDao) { 
        
        this.postDao = postDao;
        
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        
        
        
        return "index";
        
    }

   

}
