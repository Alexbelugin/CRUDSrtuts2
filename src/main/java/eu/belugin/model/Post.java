package eu.belugin.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private Integer id;
    private String txt;
    private boolean isHidden;
    private List<Post> replies;
    private String replyTxt;
    private Integer replyPointer;
    private Integer repliedPostId;

    public Post() {

    }

    public Post(Integer id, String txt) {
        this.id = id;
        this.txt = txt;
        this.isHidden = false;
//        this.replies = new ArrayList<>();
    }

    public Post(Integer id, String txt, boolean isHidden) {
        this.id = id;
        this.txt = txt;
        this.isHidden = isHidden;
//        this.replies = new ArrayList<>();
    }

    public Post(Integer id, String txt, Integer repliedPostId) {
        this.id = id;
        this.txt = txt;
        this.repliedPostId = repliedPostId;
    }

    public Post(Integer id, String txt, boolean isHidden, List<Post> replies) {
        this.id = id;
        this.txt = txt;
        this.isHidden = isHidden;
        this.replies = replies;
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

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public List<Post> getReplies() {
        return replies;
    }

    public Post getReplyFromReplies(Integer id) {
        return replies.get(id - 1);
    }

    public void setReplies(List<Post> replies) {
        this.replies = replies;
    }

    public void setReplyToReplies(Post post) {
        this.replies.add(post);
    }

    public String getReplyTxt() {
        return replyTxt;
    }

    public void setReplyTxt(String replyTxt) {
        this.replyTxt = replyTxt;
    }

    public Integer getReplyPointer() {
        return replyPointer;
    }

    public void setReplyPointer(Integer replyPointer) {
        this.replyPointer = replyPointer;
    }

    public Integer getRepliedPostId() {
        return repliedPostId;
    }

    public void setRepliedPostId(Integer repliedPostId) {
        this.repliedPostId = repliedPostId;
    }
}
