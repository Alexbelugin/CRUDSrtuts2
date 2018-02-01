package eu.belugin.model;

public abstract class AbstractPost {
    private Integer id;
    private String txt;

    public AbstractPost() {

    }

    public AbstractPost(Integer id, String txt) {
        this.id = id;
        this.txt = txt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
