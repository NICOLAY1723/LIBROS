
package com.example.literatureapi.model;

public class Book {
    private String title;
    private String[] author_name;  // Array de String
    private String[] languages;    // Array de String
    private int download_count;

    // Getters y Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String[] author_name) {
        this.author_name = author_name;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }
}
