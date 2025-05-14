package com.example.urlshortener.infrastructure.persistence;

import com.example.urlshortener.domain.model.Url;
import com.example.urlshortener.domain.ports.out.UrlRepositoryPort;
import com.example.urlshortener.infrastructure.persistence.entity.UrlEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UrlRepositoryAdapter implements UrlRepositoryPort {

    private final JpaUrlRepository jpaUrlRepository;

    @Override
    public boolean existsById(String id) {
        return jpaUrlRepository.existsById(id);
    }

    @Override
    public Url findById(String id) {
        return jpaUrlRepository.findById(id)
                .map(UrlEntity::toDomain)
                .orElseThrow(() -> new RuntimeException("Url not found"));
    }

    @Override
    public Url save(Url url) {
        return jpaUrlRepository.save(UrlEntity.fromDomain(url)).toDomain();
    }
}
