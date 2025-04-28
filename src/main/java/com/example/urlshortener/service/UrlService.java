package com.example.urlshortener.service;

import com.example.urlshortener.model.dto.ShortenUrlRequest;
import com.example.urlshortener.model.entity.UrlEntity;
import com.example.urlshortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public String createShortUrl(ShortenUrlRequest data) {
        String id;

        do {
            int length = ThreadLocalRandom.current().nextInt(5, 11);
            id = RandomStringUtils.randomAlphanumeric(length);
        }while (urlRepository.existsById(id));

        urlRepository.save(
               new UrlEntity(id,data.url(), LocalDateTime.now().plusMinutes(5))
        );

        return id;
    }

    public String getUrl(String id) {
        UrlEntity url = urlRepository.findById(id).orElseThrow(() -> new RuntimeException("Url not found"));

        return url.getFullUrl();
    }
}
