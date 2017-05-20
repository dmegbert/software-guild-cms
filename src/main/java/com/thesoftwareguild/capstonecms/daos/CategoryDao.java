package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.Category;
import java.util.List;

public interface CategoryDao {

    Category add(Category category);

    Category get(Integer id);

    List<Category> list();

    void remove(Integer id);

    List<Category> search(String search);

    void update(Category category);
    
}
