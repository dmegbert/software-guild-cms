package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.Page;
import java.util.List;


public interface PageDao {

    Page add(Page page);

    Page get(Integer id);

    List<Page> list();

    void remove(Integer id);

    List<Page> search(String search);

    void update(Page page);
    
}
