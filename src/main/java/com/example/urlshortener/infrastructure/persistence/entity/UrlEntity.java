package com.example.urlshortener.infrastructure.persistence.entity;

import com.example.urlshortener.domain.model.Url;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrlEntity {

    @Id
    private String id;

    private String fullUrl;

    private LocalDateTime expireAt;

    public Url toDomain() {
        return new Url(id, fullUrl, expireAt);
    }


    public static UrlEntity fromDomain(Url url) {
        return new UrlEntity(url.getId(), url.getFullUrl(), url.getExpireAt());
    }
}
