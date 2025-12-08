package com.example.bean;

public class BookVO {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String published_date;
    private String genre;
    private int cnt;

    public BookVO() {}

    public BookVO(int id, String title, String author, String publisher, String published_date, String genre, int cnt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.published_date = published_date;
        this.genre = genre;
        this.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
