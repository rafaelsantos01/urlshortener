package com.example.urlshortener.domain.model;

import java.time.LocalDateTime;

public class Url {

    private String id;

    private String fullUrl;

    private LocalDateTime expiraAt;

    public Url(String id, String fullUrl, LocalDateTime expiraAt) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.expiraAt = expiraAt;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LocalDateTime getExpiraAt() {
        return expiraAt;
    }

    public void setExpiraAt(LocalDateTime expiraAt) {
        this.expiraAt = expiraAt;
    }


}
