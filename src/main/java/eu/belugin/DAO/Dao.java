package eu.belugin.DAO;

import eu.belugin.model.Reply;
import eu.belugin.model.SuperPost;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static List<SuperPost> posts;
    private static Integer counter;
//    private static List<Reply> replies;

    static {
//        replies = new ArrayList<>();
//        replies.add(new Reply(0, "replaj to 2", 2));
        posts = new ArrayList<>();
        posts.add(new SuperPost(0, "hello"));
        posts.add(new SuperPost(1, "dg", true));
        posts.add(new SuperPost(2, "fyva", true));
        posts.add(new SuperPost(3, "hgdfhllo"));
        posts.add(new SuperPost(4, "qwerty"));
//        posts.add(new SuperPost(5, "privet mir", false, new ArrayList<>(Arrays.asList(new Post(1, "i tebe mir", 5)))));
        counter = 5;
    }

    public static List<SuperPost> getAllPosts() {
        return posts;
    }

    public static void setPosts(List<SuperPost> posts) {
        Dao.posts = posts;
    }

//    public static List<Reply> getReplies() {
//        return replies;
//    }
//
//    public static void setReplies(List<Reply> replies) {
//        Dao.replies = replies;
//    }

    public static List<SuperPost> getPosts() {
        return posts;
    }

    public static void deletePost(Integer id) {
        SuperPost d = null;
        for (SuperPost post :posts) {
            if (post.getId().equals(id)) {
                d = post;
            }
        }
        if (d != null) {
            posts.remove(d);
        }
//        for (SuperPost post :posts) {
//            post.setId(posts.indexOf(post));
//        }
    }

//    public static void deleteReply(SuperPost post) {
////        Post d = posts.get(post.getId() - 1);
//
////        posts.get(post.getId() - 1).getReplies().remove(post.getId() - 1);
////        for (Post p :posts.get(post.getId() - 1).getReplies()) {
////            p.setId(posts.get(post.getId() - 1).getReplies().indexOf(p) + 1);
////        }
//
//        Post d = null;
//        for (Post p :posts.get(post.getId() - 1).getReplies()) {
//            if (p.getId().equals(post.getReplyPointer())) {
//                d = p;
//            }
//        }
//        if (d != null) {
//            posts.get(post.getId() - 1).getReplies().remove(d);
//        }
//        for (Post p :posts.get(post.getId() - 1).getReplies()) {
//            p.setId(posts.get(post.getId() - 1).getReplies().indexOf(p) + 1);
//        }
//
//    }

//    public static void addPost(String txt) {
//        posts.add(new Post(posts.size() + 1, txt));
//    }

    public static void addPost(SuperPost post) {
        if (post.getId() == null) {
            post.setId(counter++);
            posts.add(post);
        } else {
            ArrayList<SuperPost> tempPosts = (ArrayList<SuperPost>) posts;
//            post.setReplies(posts.get(post.getId() - 1).getReplies());
            Integer position = null;
            for (SuperPost superPost :posts) {
                if (post.getId().equals(superPost.getId())) {
                    position = posts.indexOf(superPost);
                }
            }
            if (position != null) {
                tempPosts.set(position, post);
            }
            posts = tempPosts;
        }
    }

    public static void addReply(Reply reply) {
//        if (posts.get(reply.getSuperPostId()).getReplies() == null) {
//        reply.setId(reply.getSuperPostId());
////        posts.get(Integer.parseInt(reply.getSuperPost())) = new SuperPost();
//        posts.get(reply.getSuperPostId()).getReplies().add(reply);
//        }
//        reply.setId(replies.size());
//        replies.add(reply);
////        Post tempPost = posts.get(post.getId() - 1);
//        if (posts.get(post.getId() - 1).getReplies() == null) {
//            posts.get(post.getId() - 1).setReplies(new ArrayList<>(Arrays.asList(new Post(1, post.getReplyTxt(), post.getId()))));
////            posts.get(post.getId() - 1).setRepliedPostId(post.getId());
//        } else {
//            posts.get(post.getId() - 1).setReplyToReplies(new Post(posts.get(post.getId() - 1).getReplies().size() + 1, post.getReplyTxt(), post.getId()));
////            posts.get(post.getId() - 1).setRepliedPostId(post.getId());
//        }
    }

    public static void editPost(Integer id, String txt) {
        posts.get(id).setTxt(txt);
    }

    public static SuperPost getPost(Integer id) {
        return posts.get(id);
    }

    public static void hidePost(SuperPost post) {
        Integer position = null;
        for (SuperPost superPost :posts) {
            if (post.getId().equals(superPost.getId())) {
                position = posts.indexOf(superPost);
            }
        }

        if (position != null) {
            posts.get(position).setHidden(true);
        }
    }

    public static void restorePost(SuperPost post) {
        Integer position = null;
        for (SuperPost superPost :posts) {
            if (post.getId().equals(superPost.getId())) {
                position = posts.indexOf(superPost);
            }
        }

        if (position != null) {
            posts.get(position).setHidden(false);
        }

//        posts.get(post.getId()).setHidden(false);
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        Dao.counter = counter;
    }
}
