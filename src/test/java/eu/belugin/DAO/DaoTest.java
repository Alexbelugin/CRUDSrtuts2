package eu.belugin.DAO;

import eu.belugin.model.Post;
import eu.belugin.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class DaoTest {

    private static int size1;

    static {
        size1 = Dao.getPosts().size();
    }

    @Test
    public void addPost() {
        Dao dao = new Dao();
        dao.addPost(new Post(), new User());
        assertEquals(11, size1 + 1);
    }

    @Test
    public void deletePostCheck() {
        Dao dao = new Dao();
        dao.deletePostCheck(new Post(5), new User());
        assertEquals(9, size1 - 1);
    }

    @Test
    public void addPostTest() {
        Dao dao = new Dao();
        dao.addPost(new Post(6, "string size twenty two"), new User());
        assertEquals(22, Dao.getPosts().get(5).getTxt().length());
    }


}