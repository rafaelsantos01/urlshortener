package com.example.urlshortener.model.dto;

import jakarta.validation.constraints.NotBlank;

public record ShortenUrlRequest(
       @NotBlank String url

) {
}
