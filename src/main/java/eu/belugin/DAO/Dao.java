package eu.belugin.DAO;

import eu.belugin.model.Post;
import eu.belugin.model.User;

import java.util.*;

public class Dao {
    private static List<Post> posts;
    private static Set<String> logins;
    private static List<User> users;
    private static Integer counter = 0;

    static {
        posts = new ArrayList<>();
        logins = new HashSet<>();
        User user = new User("Beluginni","Beluginni");
        Post post1 = new Post(getCounter(), "I'll send Tesla to Mars", user);
        Post post2 = new Post(getCounter(), "Take mine as well");
        Post post3 = new Post(getCounter(), "Just give it to me");
        Post post4 = new Post(getCounter(), "I'm full!");
        Post post5 = new Post(getCounter(), "U r fool");
        Post post6 = new Post(getCounter(), "hi!");

        post1.setChildPosts(new ArrayList<>(Arrays.asList(post2, post3)));
        post4.setChildPosts(new ArrayList<>(Arrays.asList(post5, post6)));
        post2.setParent(post1);
        post3.setParent(post1);
        post5.setParent(post4);
        post6.setParent(post4);
//        post2.setChildPosts(Collections.singletonList(post4));

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);

        users = new ArrayList<>();
        users.add(user);
        for (User user1 : users) {
            logins.add(user1.getLogin());
        }
    }

//    public static List<Post> getPosts() {
//        return posts;
//    }
//
//    public static void setReplies(List<Post> posts) {
//        Dao.posts = posts;
//    }


    public static void deletePost(Integer id) {
        Post d = null;
        for (Post post : posts) {
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
////        Postold d = posts.get(post.getId() - 1);
//
////        posts.get(post.getId() - 1).getPosts().remove(post.getId() - 1);
////        for (Postold p :posts.get(post.getId() - 1).getPosts()) {
////            p.setId(posts.get(post.getId() - 1).getPosts().indexOf(p) + 1);
////        }
//
//        Postold d = null;
//        for (Postold p :posts.get(post.getId() - 1).getPosts()) {
//            if (p.getId().equals(post.getReplyPointer())) {
//                d = p;
//            }
//        }
//        if (d != null) {
//            posts.get(post.getId() - 1).getPosts().remove(d);
//        }
//        for (Postold p :posts.get(post.getId() - 1).getPosts()) {
//            p.setId(posts.get(post.getId() - 1).getPosts().indexOf(p) + 1);
//        }
//
//    }

//    public static void addPost(String txt) {
//        posts.add(new Postold(posts.size() + 1, txt));
//    }

    public static void addPost(Post post) {
        if (post.getId() == null) {
            post.setId(getCounter());
            posts.add(post);
        } else {
            for (Post postToEdit : posts) {
                if (post.getId().equals(postToEdit.getId())) {
                    postToEdit.setTxt(post.getTxt());
                }
            }
        }
    }

    public static void addReply(Post post, Integer id) {
        for (Post post1 : posts) {
            if (post1.getId().equals(id)) {
                post.setParent(post1);
                post.setId(getCounter());
                if (post1.getChildPosts() == null) {
                    post1.setChildPosts(new ArrayList<>());
                }
                post1.getChildPosts().add(post);
            }
        }
        posts.add(post);

    }

    public static boolean deleteReply(Integer id) {
        for (Post post1 :posts) {
            if (post1.getId().equals(id)) {
                for (Post post :posts) {
                    if (post1.getParent().getId().equals(post.getId())) {
                        post.getChildPosts().remove(post1);
                        posts.remove(post1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void editPost(Integer id, String txt) {
        posts.get(id).setTxt(txt);
    }
//    TODO id != index (done)
//    TODO return null ok?
    public static Post getPost(Integer id) {
        for (Post post :posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }

        return null;
    }

    public static void hidePost(Post post) {
        for (Post postToHide : posts) {
            if (post.getId().equals(postToHide.getId())) {
                postToHide.setHidden(true);
            }
        }
    }

    public static void restorePost(Post post) {
        for (Post postToRestore : posts) {
            if (post.getId().equals(postToRestore.getId())) {
                postToRestore.setHidden(false);
            }
        }

//        posts.get(post.getId()).setHidden(false);
    }

    public static Integer getCounter() {
        return counter++;
    }

    public static List<Post> getAllReplies() {
        return posts;
    }

    public static Set<String> getLogins() {
        return logins;
    }

    public static void setLogins(Set<String> logins) {
        Dao.logins = logins;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Dao.users = users;
    }
}
