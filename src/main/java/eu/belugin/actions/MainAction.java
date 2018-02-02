package eu.belugin.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationAware;
import eu.belugin.DAO.Dao;
import eu.belugin.model.Post;
import eu.belugin.model.User;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

public class MainAction extends ActionSupport implements ValidationAware /*implements Preparable*/ {
    
    private Post post;
    private List<Post> posts;
    private User user;
    private Integer id;

    @Override
    public String execute() {
        if (post != null && post.getId() != null) {
            post = Dao.getPost(post.getId());
        }
//        else if (post == null) {
//            post = new SuperPost();
//            post.setId(String.valueOf(Dao.getAllPosts().size()));
//        } else {
//            post.setId(String.valueOf(Dao.getAllPosts().size()));
//        }

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
        setPosts(notDeleted);
//        setPosts(Dao.getPosts());

        return SUCCESS;
    }

    public String addPost() throws Exception {
        Dao.addPost(post);

        return SUCCESS;
    }

//    TODO add validation empty reply
    public void validateAddPost() {
        if (user != null && user.getLogin() != null && !user.getLogin().isEmpty()) {
            if (Dao.getLogins().contains(user.getLogin())) {
                for (User user1 : Dao.getUsers()) {
                    if (!user.getPassword().equals(user1.getPassword())) {
                        addActionError("Password is wrong");
                    }
                }
            }
        }


        if (post == null || post.getTxt() == null || post.getTxt().isEmpty()) {
            addActionError("txt not pustoj");
        }
    }

    public String hidePost() throws Exception {
        Dao.hidePost(post);
        return SUCCESS;
    }

    public String showDeletedPosts() throws Exception {
        List<Post> postList = Dao.getAllReplies();
        List<Post> notDeleted = new ArrayList<>();
        for (Post p : postList) {
            if (p.isHidden()) {
                notDeleted.add(p);
            }
        }

        setPosts(notDeleted);

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
        Dao.addReply(post, id);

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
        return "ALALAAL";
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
}
