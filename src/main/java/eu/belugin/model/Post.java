package eu.belugin.model;

import java.util.List;

public class Post {
    private Integer id;
    private String txt;
    private Post parent;
    private User user;
    private List<Post> childPosts;
    private boolean hidden;

    public Post() {}

    public Post(Integer id, String txt, Post parent, List<Post> childPosts, boolean hidden) {
        this.id = id;
        this.txt = txt;
        this.parent = parent;
        this.childPosts = childPosts;
        this.hidden = hidden;
    }

    public Post(Integer id, String txt) {
        this.id = id;
        this.txt = txt;
    }

    public Post(Integer id, String txt, User user) {
        this.id = id;
        this.txt = txt;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public List<Post> getChildPosts() {
        return childPosts;
    }

    public void setChildPosts(List<Post> childPosts) {
        this.childPosts = childPosts;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
