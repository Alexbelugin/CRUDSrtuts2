package eu.belugin.model;

import java.util.List;

public class SuperPost extends AbstractPost {
    private boolean isHidden;
    private List<Reply> replies;

    public SuperPost() {
        super();
    }

    public SuperPost(Integer id, String txt) {
        super(id, txt);
        this.isHidden = false;
    }

    public SuperPost(Integer id, String txt, boolean isHidden) {
        super(id, txt);
        this.isHidden = isHidden;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Reply getOneRepliy(Integer id) {
        return replies.get(id);
    }

    public void setOneRepliy(Reply reply) {
        this.replies.add(reply);
    }
}
