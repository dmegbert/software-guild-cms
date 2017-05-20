package com.thesoftwareguild.capstonecms.controllers;

import com.thesoftwareguild.capstonecms.daos.PageDao;
import com.thesoftwareguild.capstonecms.dtos.Page;
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
@RequestMapping(value = "/page")
public class PageController {

    private PageDao pageDao;

    @Inject
    public PageController(PageDao pageDao) {
        this.pageDao = pageDao;

    }

    @RequestMapping(value = "/create")
    public String create() {
        return "addpage";
    }

    
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Page add(@Valid @RequestBody Page page) {

        Page addedPage = pageDao.add(page);

        return addedPage;

    }

    @RequestMapping(value = "/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        Page page = pageDao.get(id);
        
        model.addAttribute("page", page);

        return "showpage";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer pageId) {

        pageDao.remove(pageId);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Page edit(@RequestBody Page page) {

        pageDao.update(page);

        return page;

    }

}
