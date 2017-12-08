package com.gallusawa.newsapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gallusawa on 12/7/17.
 */
public class Article {

    @Expose
    private String sourceId;
    @SerializedName("author")
    private String author;
    @SerializedName("urlToImage")
    private String imageUrl;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String decr;
    @SerializedName("url")
    private String url;
    @SerializedName("publishedAt")
    private String publishedAt;

    public Article() {
    }

    public Article( String author, String imageUrl, String title, String decr, String url, String publishedAt) {
        this.author = author;
        this.imageUrl = imageUrl;
        this.title = title;
        this.decr = decr;
        this.url = url;
        this.publishedAt = publishedAt;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecr() {
        return decr;
    }

    public void setDecr(String decr) {
        this.decr = decr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

}
