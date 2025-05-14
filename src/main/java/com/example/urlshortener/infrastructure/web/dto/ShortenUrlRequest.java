package com.example.urlshortener.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;

public record ShortenUrlRequest(
       @NotBlank String url

) {
}
