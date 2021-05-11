package com.example.myfavoritephotos.model;

public class Image {
    Integer id;
    String title;
    byte[] imageContent;

    public Image(Integer id, String title, byte[] imageContent) {
        this.id = id;
        this.title = title;
        this.imageContent = imageContent;
    }

    public Image(String title, byte[] imageContent) {
        this.title = title;
        this.imageContent = imageContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }
}
