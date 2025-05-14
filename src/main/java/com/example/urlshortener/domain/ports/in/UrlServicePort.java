package com.example.urlshortener.domain.ports.in;

import com.example.urlshortener.infrastructure.web.dto.ShortenUrlRequest;

public interface UrlServicePort {

    String createShortUrl(ShortenUrlRequest data);

    String getUrl(String id);

}
