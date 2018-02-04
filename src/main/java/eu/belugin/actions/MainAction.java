package eu.belugin.actions;

import com.opensymphony.xwork2.ActionSupport;
import eu.belugin.DAO.Dao;
import eu.belugin.model.Post;
import eu.belugin.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainAction extends ActionSupport /*implements Preparable*/ {

    private Post post;
    private List<Post> posts;
    private User user;
    private Integer id;
    private final String ANON = "anonymous";

    @Override
    public String execute() {
        if (post != null && post.getId() != null) {
            post = Dao.getPost(post.getId());
        }

        return SUCCESS;
    }

//    public void prepare() throws Exception {
//
//    }

    public String showPosts() {
        List<Post> postList = Dao.getAllReplies();
        List<Post> notDeleted = new ArrayList<>();
        for (Post p : postList) {
            if (!p.isHidden()) {
                notDeleted.add(p);
            }
        }
        Collections.reverse(notDeleted);
        setPosts(notDeleted);
//        setPosts(Dao.getPosts());
        id = null;
        user = null;
        post = null;

        return SUCCESS;
    }

    public String addPost() throws Exception {
        Dao.addPost(post, user);

        return SUCCESS;
    }

    public void validation() {
        if (user != null && user.getName() != null && !user.getName().isEmpty()) {
            if (Dao.getNames().contains(user.getName())) {
                for (User user1 : Dao.getUsers()) {
                    if (user.getName().equals(user1.getName())) {
                        if (!user.getPassword().equals(user1.getPassword())) {
                            addActionError("Password is wrong");
                        }
                    }
                }
            }
        }
        if (post == null || post.getTxt() == null || post.getTxt().isEmpty()) {
            addActionError("Type something");
        }
        if (user.getName().equals(ANON)) {
            addActionError("Can't use that name");
        } else if (!user.getName().isEmpty()) {
            if (user.getPassword().isEmpty()) {
                addActionError("Type password");
            }
        }
//        if (post.getUser().getName().equals("anonymous")) {
//            addActionError("Choose the name");
//        }
    }

    public void validateAddPost() {
        validation();
    }

    public void validateAddReply() {
        validation();
    }

    public void validationEditPost() {
        validation();
    }

    public String hidePost() throws Exception {
        Dao.hidePost(post);
        return SUCCESS;
    }

    public String showHiddenPosts() throws Exception {
        List<Post> postList = Dao.getAllReplies();
        List<Post> hidden = new ArrayList<>();
        for (Post p : postList) {
            if (p.isHidden()) {
                hidden.add(p);
            }
        }
        Collections.reverse(hidden);
        setPosts(hidden);

        return SUCCESS;
    }

    public String restoreHiddenPost() throws Exception {
        Dao.restorePost(post);
        return SUCCESS;
    }

    public String deletePost() throws Exception {
        Dao.deletePost(post.getId());

        return SUCCESS;
    }

    public String addReply() throws Exception {
        Dao.addReply(post, id, user);

        return SUCCESS;
    }

    public String deleteReply() throws Exception {
        Dao.deleteReply(id);
        return SUCCESS;
    }
//
//    public String deleteReply() throws Exception {
//        Dao.deleteReply(post);
//
//        return SUCCESS;
//    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List getPosts() {
        return posts;
    }

    private void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Post getPost() {
        return post;
    }

//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }

    public String printString() {
        return "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getANON() {
        return ANON;
    }
}
