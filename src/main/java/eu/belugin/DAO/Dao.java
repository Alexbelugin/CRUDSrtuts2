package eu.belugin.DAO;

import eu.belugin.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dao {
    private static List<Post> posts;

    static {
        posts = new ArrayList<>();
        posts.add(new Post(1, "hello"));
        posts.add(new Post(2, "dg", true));
        posts.add(new Post(3, "fyva", true));
        posts.add(new Post(4, "hgdfhllo"));
        posts.add(new Post(5, "qwerty"));
        posts.add(new Post(6, "privet mir", false, new ArrayList<>(Arrays.asList(new Post(1, "i tebe mir", 6)))));
    }

    public static List<Post> getAllPosts() {
        return posts;
    }

    public static void setPosts(List<Post> posts) {
        Dao.posts = posts;
    }

    public static void deletePost(Integer id) {
        Post d = null;
        for (Post post :posts) {
            if (post.getId().equals(id)) {
                d = post;
            }
        }
        if (d != null) {
            posts.remove(d);
        }
        for (Post post :posts) {
            post.setId(posts.indexOf(post) + 1);
        }
    }

    public static void deleteReply(Post post) {
//        Post d = posts.get(post.getId() - 1);

//        posts.get(post.getId() - 1).getReplies().remove(post.getId() - 1);
//        for (Post p :posts.get(post.getId() - 1).getReplies()) {
//            p.setId(posts.get(post.getId() - 1).getReplies().indexOf(p) + 1);
//        }

        Post d = null;
        for (Post p :posts.get(post.getId() - 1).getReplies()) {
            if (p.getId().equals(post.getReplyPointer())) {
                d = p;
            }
        }
        if (d != null) {
            posts.get(post.getId() - 1).getReplies().remove(d);
        }
        for (Post p :posts.get(post.getId() - 1).getReplies()) {
            p.setId(posts.get(post.getId() - 1).getReplies().indexOf(p) + 1);
        }

    }

//    public static void addPost(String txt) {
//        posts.add(new Post(posts.size() + 1, txt));
//    }

    public static void addPost(Post post) {
        if (post.getId() == null) {
            post.setId(posts.size() + 1);
            posts.add(post);
        } else {
            ArrayList<Post> tempPosts = (ArrayList<Post>) posts;
            post.setReplies(posts.get(post.getId() - 1).getReplies());
            tempPosts.set(post.getId() - 1, post);
            posts = tempPosts;
        }
    }

    public static void addReply(Post post) {
//        Post tempPost = posts.get(post.getId() - 1);
        if (posts.get(post.getId() - 1).getReplies() == null) {
            posts.get(post.getId() - 1).setReplies(new ArrayList<>(Arrays.asList(new Post(1, post.getReplyTxt(), post.getId()))));
//            posts.get(post.getId() - 1).setRepliedPostId(post.getId());
        } else {
            posts.get(post.getId() - 1).setReplyToReplies(new Post(posts.get(post.getId() - 1).getReplies().size() + 1, post.getReplyTxt(), post.getId()));
//            posts.get(post.getId() - 1).setRepliedPostId(post.getId());
        }

    }

    public static void editPost(Integer id, String txt) {
        posts.get(id - 1).setTxt(txt);
    }

    public static Post getPost(Integer id) {
        return posts.get(id - 1);
    }

    public static void hidePost(Post post) {
        posts.get(post.getId() - 1).setHidden(true);
    }

    public static void restorePost(Post post) {
        posts.get(post.getId() - 1).setHidden(false);
    }
}
