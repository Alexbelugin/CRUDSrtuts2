package eu.belugin.model;

import java.util.List;

public class Reply extends AbstractPost {
    private Integer superPostId;
    private List<Reply> replies;

    public Reply() {
        super();
    }

    public Reply(Integer id, String txt, Integer superPostId) {
        super(id, txt);
        this.superPostId = superPostId;
    }

    public Integer getSuperPostId() {
        return superPostId;
    }

    public void setSuperPostId(Integer superPostId) {
        this.superPostId = superPostId;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
