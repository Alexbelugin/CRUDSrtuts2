package eu.belugin.DAO;

import eu.belugin.actions.MainAction;
import eu.belugin.model.Post;
import eu.belugin.model.User;

import java.util.*;

public class Dao {
    private static List<Post> posts;
    private static Set<String> names;
    private static List<User> users;
    private static Integer counter = 0;

    static {
        posts = new ArrayList<>();
        names = new HashSet<>();
        User user = new User("Elon Musk", "12345");
        Post post1 = new Post(getCounter(), "Stars are the limit", "I'll send Tesla to Mars", user);
        Post post2 = new Post(getCounter(), "Take mine as well", new User());
        Post post3 = new Post(getCounter(), "Just give it to me", new User());
        Post post4 = new Post(getCounter(), "Not a joke", "I'm full!", new User());
        Post post5 = new Post(getCounter(), "U r fool", new User());
        Post post6 = new Post(getCounter(), "hi!", new User());

        post1.setReplies(new ArrayList<>(Arrays.asList(post2, post3)));
        post4.setReplies(new ArrayList<>(Arrays.asList(post5, post6)));
        post2.setParent(post1);
        post3.setParent(post1);
        post5.setParent(post4);
        post6.setParent(post4);
//        post2.setReplies(Collections.singletonList(post4));

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);

        users = new ArrayList<>();
        users.add(user);
        for (User user1 : users) {
            names.add(user1.getName());
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
    }


    public static void addPost(Post post, User user) {
        if (post.getId() == null) {
            post.setId(getCounter());
            posts.add(post);
            userNameCheck(post, user);
        } else {
            for (Post postToEdit : posts) {
                if (post.getId().equals(postToEdit.getId())) {
                    postToEdit.setTxt(post.getTxt());
                }
            }
        }
    }

    public static void addReply(Post post, Integer id, User user) {
        for (Post post1 : posts) {
            if (post1.getId().equals(id)) {
                post.setParent(post1);
                post.setId(getCounter());
                if (post1.getReplies() == null) {
                    post1.setReplies(new ArrayList<>());
                }
                post1.getReplies().add(post);
            }
        }
        posts.add(post);
        userNameCheck(post, user);
    }

    private static void userNameCheck(Post post, User user) {
        user.getName().trim();
        if (user.getName().equals("") || user.getName().equals("anonymous")) {
            post.setUser(new User());
        } else if (!user.getName().equals("") && names.contains(user.getName())) {
            post.setUser(user);
        } else if (user.getName() != null && !user.getName().equals("anonymous")) {
            names.add(user.getName());
            users.add(user);
            post.setUser(user);
        }
    }

    public static boolean deleteReply(Integer id) {
        for (Post post1 : posts) {
            if (post1.getId().equals(id)) {
                for (Post post : posts) {
                    if (post1.getParent().getId().equals(post.getId())) {
                        post.getReplies().remove(post1);
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

    public static Post getPost(Integer id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }

        return null;
    }

    public static String hidePostCheck(Post post, User user) {
        if (user.getName().equals(MainAction.getANON())) {
            hidePost(post);
            return MainAction.SUCCESS;
        } else {
            for (User user1 :users) {
                if (user.getName().equals(user1.getName())) {
                    if (user.getPassword() == null || !user.getPassword().equals(user1.getPassword())) {
                        return MainAction.ERROR;
                    } else {
                        hidePost(post);
                        return MainAction.SUCCESS;
                    }
                }
            }
        }
        return null;
    }

    private static void hidePost(Post post) {
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

    private static Integer getCounter() {
        return counter++;
    }

    public static List<Post> getAllReplies() {
        return posts;
    }

    public static Set<String> getNames() {
        return names;
    }

    public static void setNames(Set<String> names) {
        Dao.names = names;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Dao.users = users;
    }
}
