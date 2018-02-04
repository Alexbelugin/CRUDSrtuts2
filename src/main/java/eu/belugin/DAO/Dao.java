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
        users = new ArrayList<>();
        User user = new User("Elon Musk", "12345");
        User admin = new User("Admin", "admin");
        users.add(user);
        users.add(admin);
        for (User userok : users) {
            names.add(userok.getName());
        }
        Post post1 = new Post(getCounter(), "Stars are the limit", "I'll send Tesla to Mars", user);
        Post post2 = new Post(getCounter(), "Take mine as well", new User());
        Post post3 = new Post(getCounter(), "Just give it to me", new User());
        Post post4 = new Post(getCounter(), "Not a joke", "I'm full!", new User(), true);
        Post post5 = new Post(getCounter(), "U r fool", new User());
        Post post6 = new Post(getCounter(), "hi!", new User());
        Post post7 = new Post(getCounter(), "Welcome! This is post's title",
                "You can add new post by clicking on New Post button in the left corner.\n\nYou can add post " +
                        "anonymously, or with your name and password. If you are new, just type your name and password " +
                        "you want.\n\nPosts with password you can edit, hide add delete only with password. Same" +
                        " idea with replies, but deleting is the only option.\n\nTo try the system, take my pass: admin." +
                        "\n\nIf you want to post and reply anonymously, it's your choice. But everybody can do " +
                        "everything with your posts and replies.",
                admin);
        Post post8 = new Post(getCounter(), "This is reply under password. Your can't delete it without password",
                admin);
        Post post9 = new Post(getCounter(), "This is anonymous post. Hide it, edit it, delete it. Do what you want!",
                new User());
        Post post10 = new Post(getCounter(), "This is anonymous reply. Everybody can delete it.",
                new User());

        post1.setReplies(new ArrayList<>(Arrays.asList(post2, post3)));
        post4.setReplies(new ArrayList<>(Arrays.asList(post5, post6)));
        post7.setReplies(new ArrayList<>(Arrays.asList(post8, post10)));
        post2.setParent(post1);
        post3.setParent(post1);
        post5.setParent(post4);
        post6.setParent(post4);
        post8.setParent(post7);
        post10.setParent(post7);

//        post2.setReplies(Collections.singletonList(post4));

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
        posts.add(post7);
        posts.add(post8);
        posts.add(post9);
        posts.add(post10);

    }

    //    public static List<Post> getPosts() {
//        return posts;
//    }
//
//    public static void setReplies(List<Post> posts) {
//        Dao.posts = posts;
//    }
    public static String deletePostCheck(Post post, User user) {
        if (user.getName().equals(MainAction.getANON())) {
            deletePost(post);
            return MainAction.SUCCESS;
        } else {
            for (User user1 : users) {
                if (user.getName().equals(user1.getName())) {
                    if (user.getPassword() == null || !user.getPassword().equals(user1.getPassword())) {
                        return MainAction.ERROR;
                    } else {
                        deletePost(post);
                        return MainAction.SUCCESS;
                    }
                }
            }
        }
        return null;
    }

    private static void deletePost(Post post) {
        Post d = null;
        for (Post post1 : posts) {
            if (post1.getId().equals(post.getId())) {
                d = post1;
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

    public static String deleteReplyCheck(Post post, User user) {
        if (user.getName().equals(MainAction.getANON())) {
            deleteReply(post);
            return MainAction.SUCCESS;
        } else {
            for (User user1 : users) {
                if (user.getName().equals(user1.getName())) {
                    if (user.getPassword() == null || !user.getPassword().equals(user1.getPassword())) {
                        return MainAction.ERROR;
                    } else {
                        deleteReply(post);
                        return MainAction.SUCCESS;
                    }
                }
            }
        }
        return null;
    }

    private static boolean deleteReply(Post post) {
        for (Post post1 : posts) {
            if (post1.getId().equals(post.getId())) {
                for (Post post2 : posts) {
                    if (post1.getParent().getId().equals(post2.getId())) {
                        post2.getReplies().remove(post1);
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
            for (User user1 : users) {
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

    public static List<Post> getPosts() {
        return posts;
    }

    public static void setPosts(List<Post> posts) {
        Dao.posts = posts;
    }
}
