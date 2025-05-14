package com.example.urlshortener.domain.ports.out;

import com.example.urlshortener.domain.model.Url;

public interface UrlRepositoryPort {

    boolean existsById(String id);

    Url findById(String id);

    Url save(Url url);
}
