package com.talent.noteswithoutdatabase.model;

public class Note {

    private Long id;

    private  String content;

    private String title;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
