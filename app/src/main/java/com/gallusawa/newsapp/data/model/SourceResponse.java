package com.gallusawa.newsapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gallusawa on 12/7/17.
 */
public class SourceResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("sources")
    private List<Source> sources;

    public SourceResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
