package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.CommandPost;
import com.thesoftwareguild.capstonecms.dtos.Post;
import java.util.List;


public interface PostDao {

    Post add(CommandPost post);

    Post get(Integer id);

    List<Post> list();

    void remove(Integer id);

    List<Post> search(String search);

    Post update(CommandPost post);
    
}
