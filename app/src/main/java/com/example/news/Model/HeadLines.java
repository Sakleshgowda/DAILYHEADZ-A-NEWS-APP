package com.example.news.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeadLines {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    List<Articles> articlesList;

    public HeadLines(String status, int totalResults, List<Articles> articlesList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articlesList = articlesList;
    }

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(List<Articles> articlesList) {
        this.articlesList = articlesList;
    }
}
