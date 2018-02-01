package eu.belugin.actions;

import com.opensymphony.xwork2.ActionSupport;
import eu.belugin.DAO.Dao;
import eu.belugin.model.Reply;
import eu.belugin.model.SuperPost;

import java.util.ArrayList;
import java.util.List;

public class MainAction extends ActionSupport /*implements Preparable*/ {

    private SuperPost post;
    private Reply reply;
    private List<SuperPost> posts;
//    private List<Reply> replies;

    @Override
    public String execute() throws Exception {
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
        List<SuperPost> postList = Dao.getAllPosts();
        List<SuperPost> notDeleted = new ArrayList<>();
        for (SuperPost p :postList) {
            if (!p.isHidden()) {
                notDeleted.add(p);
            }
        }
        setPosts(notDeleted);
//        setReplies(Dao.getReplies());

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
        List<SuperPost> postList = Dao.getAllPosts();
        List<SuperPost> notDeleted = new ArrayList<>();
        for (SuperPost p :postList) {
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
        Dao.addReply(reply);

        return SUCCESS;
    }
//
//    public String deleteReply() throws Exception {
//        Dao.deleteReply(post);
//
//        return SUCCESS;
//    }

    public SuperPost getPost() {
        return post;
    }

    public void setPost(SuperPost post) {
        this.post = post;
    }

    public List getPosts() {
        return posts;
    }

    private void setPosts(List<SuperPost> posts) {
        this.posts = posts;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

//    public List<Reply> getReplies() {
//        return replies;
//    }
//
//    public void setReplies(List<Reply> replies) {
//        this.replies = replies;
//    }
}
