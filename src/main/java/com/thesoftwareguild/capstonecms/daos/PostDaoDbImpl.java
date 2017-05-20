package com.thesoftwareguild.capstonecms.daos;

import com.thesoftwareguild.capstonecms.dtos.CommandPost;

import com.thesoftwareguild.capstonecms.dtos.Category;
import com.thesoftwareguild.capstonecms.dtos.Post;
import com.thesoftwareguild.capstonecms.dtos.Tag;
import com.thesoftwareguild.capstonecms.dtos.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PostDaoDbImpl implements PostDao {

    private JdbcTemplate template;
    private CategoryDao categoryDao;
    private TagDao tagDao;

    private static final String SQL_GET_POST = "select p.id, p.title, p.content, p.published, p.expiration, p.is_approved, p.created, c.id as category_id, c.name as category_name, u.id as user_id, u.user_name as user_name FROM holiday.posts p join holiday.categories c on p.category_id = c.id join holiday.users u on p.user_id = u.id where p.id = ?;";
    private static final String SQL_INSERT_POST = "INSERT INTO `holiday`.`posts` (`title`, `content`, `category_id`, `published`, `expiration`, `is_approved`, `user_id`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_CHECKTAGS_EXIST = "SELECT exists (select tags.id from tags where tags.name = ?)";
    private static final String SQL_INSERT_TAG = "INSERT INTO `holiday`.`tags` (`name`) VALUES (?)";
    private static final String SQL_GET_TAGID = "Select tags.id from tags where tags.name = ?";
    private static final String SQL_INSERT_TAG_POST_LINKING = "INSERT INTO `holiday`.`posts_tags` (`post_id`, `tag_id`) VALUES (?, ?)";
    private static final String SQL_REMOVE_POST = "";
    private static final String SQL_UPDATE_POST = "UPDATE `holiday`.`posts` SET `title`=?, `content`=?,`category_id`=?, `is_approved`=?, `user_id`=?, `published`=?,  `expiration`=? WHERE `id`=?";
    private static final String SQL_LIST = "select p.id, p.title, p.content, p.published, p.expiration, p.is_approved, p.created, c.id as category_id, c.name as category_name, u.id as user_id, u.user_name as user_name FROM holiday.posts p join holiday.categories c on p.category_id = c.id join holiday.users u on p.user_id = u.id order by published DESC;";
    private static final String SQL_SEARCH = "";
    private static final String SQL_GET_TAGS = "select t.id, t.name from holiday.posts p left join holiday.posts_tags pt on p.id = pt.post_id left join holiday.tags t on pt.tag_id = t.id where p.id = ?;";

    public PostDaoDbImpl(JdbcTemplate template, TagDao tagDao, CategoryDao categoryDao) {
        this.template = template;
        this.tagDao = tagDao;
        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Post add(CommandPost post) {
        CommandPost newPost = post;

        Integer userId = 1;
        Boolean isApproved = true;
        template.update(SQL_INSERT_POST, newPost.getTitle(),
                newPost.getContent(),
                newPost.getCategoryId(),
                newPost.getPublished(),
                newPost.getExpiration(),
                isApproved,
                userId);

        Integer postId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        String sqlGetCreated = ("SELECT posts.created FROM holiday.posts where posts.id = " + postId);
        String createdDate = template.queryForObject(sqlGetCreated, String.class);

        if (newPost.getTags() != null) {
            for (String t : newPost.getTags()) {
                Boolean isExist = template.queryForObject(SQL_CHECKTAGS_EXIST, Boolean.class, t);
                if (!isExist) {
                    template.update(SQL_INSERT_TAG, t);
                    Integer tagId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
                    template.update(SQL_INSERT_TAG_POST_LINKING, postId, tagId);

                } else {
                    Integer tagId = template.queryForObject(SQL_GET_TAGID, Integer.class, t);
                    template.update(SQL_INSERT_TAG_POST_LINKING, postId, tagId);
                }

            }
        }

        Post dbPost = new Post();

        dbPost.setId(postId);

        //add commandObject attr to dbPost
        return dbPost;
    }

    @Override
    public Post get(Integer id) {
        Post post = template.queryForObject(SQL_GET_POST, new PostMapper(), id);

        List<Tag> tags = template.query(SQL_GET_TAGS, new TagMapper(), id);

        post.setTags(tags);

        return post;
    }

    @Override
    public void remove(Integer id) {

    }
//"UPDATE `holiday`.`posts` SET `title`=?, `content`=?,`category_id`=?, 
//    `is_approved`=?, `user_id`=?, `published`=?,  `expiration`=? WHERE `id`=?";
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Post update(CommandPost post) {
       CommandPost updatePost = post;

        Integer userId = 1;
        Boolean isApproved = true;
        template.update(SQL_UPDATE_POST, updatePost.getTitle(),
                updatePost.getContent(),
                updatePost.getCategoryId(),
                isApproved,
                userId,
                updatePost.getPublished(),
                updatePost.getExpiration(),
                updatePost.getId()
                );
        Integer postId = updatePost.getId();
        
        if (updatePost.getTags() != null) {
            for (String t : updatePost.getTags()) {
                Boolean isExist = template.queryForObject(SQL_CHECKTAGS_EXIST, Boolean.class, t);
                if (!isExist) {
                    template.update(SQL_INSERT_TAG, t);
                    Integer tagId = template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
                    template.update(SQL_INSERT_TAG_POST_LINKING, postId, tagId);

                } else {
                    Integer tagId = template.queryForObject(SQL_GET_TAGID, Integer.class, t);
                    template.update(SQL_INSERT_TAG_POST_LINKING, postId, tagId);
                }

            }
        }

        Post dbPost = new Post();

        dbPost.setId(postId);

        //add commandObject attr to dbPost
        return dbPost;
    }

    @Override
    public List<Post> list() {

        List<Post> posts = template.query(SQL_LIST, new PostMapper());

        return posts;
        
    }

    @Override
    public List<Post> search(String search) {

        List<Post> posts = new ArrayList(); //shitcan for actual method

        return posts;

    }

    private static class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();

            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            post.setCreated(rs.getDate("created").toLocalDate());
            post.setPublished(rs.getDate("published").toLocalDate());
            post.setExpiration(rs.getDate("expiration").toLocalDate());
            post.setIsApproved(rs.getBoolean("is_approved"));

            Category category = new Category();
            category.setId(rs.getInt("category_id"));
            category.setName(rs.getString("category_name"));
            post.setCategory(category);

            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("user_name"));
            post.setUser(user);

            return post;
        }
    }

    private static class TagMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();

            tag.setId(rs.getInt("id"));
            tag.setName(rs.getString("name"));

            return tag;

        }
    }

}
