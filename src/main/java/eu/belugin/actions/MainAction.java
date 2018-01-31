package eu.belugin.actions;

import com.opensymphony.xwork2.ActionSupport;
import eu.belugin.DAO.Dao;
import eu.belugin.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainAction extends ActionSupport /*implements Preparable*/ {

    private Post post;
    private List<Post> posts;

    @Override
    public String execute() throws Exception {
        if (post != null && post.getId() != null) {
            post = Dao.getPost(post.getId());
        }

        return SUCCESS;
    }

//    public void prepare() throws Exception {
//
//    }

    public String showPosts() {
        List<Post> postList = Dao.getAllPosts();
        List<Post> notDeleted = new ArrayList<>();
        for (Post p :postList) {
            if (!p.isHidden()) {
                notDeleted.add(p);
            }
        }

        setPosts(notDeleted);

        return SUCCESS;
    }

    public String addPost() throws Exception {
        Dao.addPost(post);

        return SUCCESS;
    }

    public String hidePost() throws Exception {
        Dao.hidePost(post);
        return SUCCESS;
    }

    public String showDeletedPosts() throws Exception {
        List<Post> postList = Dao.getAllPosts();
        List<Post> notDeleted = new ArrayList<>();
        for (Post p :postList) {
            if (p.isHidden()) {
                notDeleted.add(p);
            }
        }

        setPosts(notDeleted);

        return SUCCESS;
    }

    public String restoreDeletedPost() throws Exception {
        Dao.restorePost(post);
        return SUCCESS;
    }

    public String deletePost() throws Exception {
        Dao.deletePost(post.getId());

        return SUCCESS;
    }

    public String addReplay() throws Exception {
        Dao.addReply(post);

        return SUCCESS;
    }

    public String deleteReply() throws Exception {
        Dao.deleteReply(post);

        return SUCCESS;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List getPosts() {
        return posts;
    }

    private void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
