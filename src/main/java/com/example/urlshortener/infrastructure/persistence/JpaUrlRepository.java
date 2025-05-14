package com.example.urlshortener.infrastructure.persistence;

import com.example.urlshortener.infrastructure.persistence.entity.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JpaUrlRepository extends MongoRepository<UrlEntity, String> {
}
