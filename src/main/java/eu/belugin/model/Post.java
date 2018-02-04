package eu.belugin.model;

import java.util.List;

public class Post {
    private Integer id;
    private String title;
    private String txt;
    private Post parent;
    private User user;
    private List<Post> replies;
    private boolean hidden;

    public Post() {}

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String txt, Post parent, List<Post> replies, boolean hidden) {
        this.id = id;
        this.txt = txt;
        this.parent = parent;
        this.replies = replies;
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

    public Post(Integer id, String title, String txt, User user) {
        this.id = id;
        this.title = title;
        this.txt = txt;
        this.user = user;
    }

    public Post(Integer id, String title, String txt) {
        this.id = id;
        this.title = title;
        this.txt = txt;
    }

    public Post(Integer id, String title, String txt, User user, boolean hidden) {
        this.id = id;
        this.title = title;
        this.txt = txt;
        this.user = user;
        this.hidden = hidden;
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

    public List<Post> getReplies() {
        return replies;
    }

    public void setReplies(List<Post> replies) {
        this.replies = replies;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
