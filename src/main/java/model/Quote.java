package model;

import java.io.Serializable;

public class Quote implements Serializable {
    private int id;
    private String content;
    private Author author;

    public Quote(String content) {
        this.content = content;
        this.author = new Author();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
