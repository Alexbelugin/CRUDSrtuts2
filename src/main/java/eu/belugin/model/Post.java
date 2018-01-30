package eu.belugin.model;

public class Post {
    private int id;
    private String txt;
    private boolean isDeleted;

    public Post() {

    }

    public Post(int id, String txt) {
        this.id = id;
        this.txt = txt;
        this.isDeleted = false;
    }

    public Post(int id, String txt, boolean isDeleted) {
        this.id = id;
        this.txt = txt;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
