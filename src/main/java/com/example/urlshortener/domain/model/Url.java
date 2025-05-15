package com.example.urlshortener.domain.model;

import java.time.LocalDateTime;

public class Url {

    private String id;

    private String fullUrl;

    private LocalDateTime expireAt;

    public Url(String id, String fullUrl, LocalDateTime expireAt) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.expireAt = expireAt;
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

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expiraAt) {
        this.expireAt = expiraAt;
    }


}
