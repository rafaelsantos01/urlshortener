package com.example.urlshortener.application.service;

import com.example.urlshortener.infrastructure.web.dto.ShortenUrlRequest;
import com.example.urlshortener.domain.model.Url;
import com.example.urlshortener.domain.ports.out.UrlRepositoryPort;
import com.example.urlshortener.domain.ports.in.UrlServicePort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class UrlService  implements UrlServicePort {

    private final UrlRepositoryPort jpaUrlRepository;

    @Override
    public String createShortUrl(ShortenUrlRequest data) {
        String id;

        do {
            int length = ThreadLocalRandom.current().nextInt(5, 11);
            id = RandomStringUtils.randomAlphanumeric(length);
        } while (jpaUrlRepository.existsById(id));

        jpaUrlRepository.save(
               new Url(id,data.url(), LocalDateTime.now().plusMinutes(5))
        );

        return id;
    }

    @Override
    public String getUrl(String id) {
        Url url = jpaUrlRepository.findById(id);
        return url.getFullUrl();
    }
}
