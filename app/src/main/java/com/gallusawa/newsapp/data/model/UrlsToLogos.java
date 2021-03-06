package com.gallusawa.newsapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gallusawa on 12/7/17.
 */

public class UrlsToLogos {

    @SerializedName("small")
    private String small;
    @SerializedName("medium")
    private String medium;
    @SerializedName("large")
    private String large;

    public UrlsToLogos() {
    }

    public UrlsToLogos(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
