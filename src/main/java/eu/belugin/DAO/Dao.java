package eu.belugin.DAO;

import eu.belugin.model.Post;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static List<Post> posts;

    static {
        posts = new ArrayList<Post>();
        posts.add(new Post(1, "hello"));
        posts.add(new Post(2, "dg", true));
        posts.add(new Post(3, "fyva", true));
        posts.add(new Post(4, "hgdfhllo"));
        posts.add(new Post(5, "qwerty"));
    }

    public static List<Post> getAllPosts() {
        return posts;
    }

    public static void setPosts(List<Post> posts) {
        Dao.posts = posts;
    }

    public static void deletePost(int id) {
        Post d = null;
        for (Post post :posts) {
            if (post.getId() == id) {
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

//    public static void addPost(String txt) {
//        posts.add(new Post(posts.size() + 1, txt));
//    }

    public static void addPost(Post post) {
        if (post.getId() == 0) {
            post.setId(posts.size() + 1);
            posts.add(post);
        } else {
            ArrayList<Post> tempPosts = (ArrayList<Post>) posts;
            tempPosts.set(post.getId() - 1, post);
            posts = tempPosts;
        }
    }

    public static void editPost(int id, String txt) {
        posts.get(id - 1).setTxt(txt);
    }

    public static Post getPost(int id) {
        return posts.get(id - 1);
    }

    public static void hidePost(Post post) {
        posts.get(post.getId() - 1).setDeleted(true);
    }

    public static void restorePost(Post post) {
        posts.get(post.getId() - 1).setDeleted(false);
    }
}
