package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.Tag;
import java.util.List;


public interface TagDao {

    Tag add(Tag tag);

    Tag get(Integer id);

    List<Tag> list();

    void remove(Integer id);

    List<Tag> search(String search);

    void update(Tag tag);
    
}
