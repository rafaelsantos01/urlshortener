package com.example.urlshortener.infrastructure.controller;

import com.example.urlshortener.infrastructure.web.dto.ShortenUrlRequest;
import com.example.urlshortener.infrastructure.web.dto.ShortenUrlResponse;
import com.example.urlshortener.application.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping()
@RestController
@AllArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/v1/shortener-url")
    @ResponseStatus(HttpStatus.CONTINUE)
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody @Valid ShortenUrlRequest data, HttpServletRequest request) {

        String url = urlService.createShortUrl(data);

        var redirectUrl = request.getRequestURL().toString().replace(request.getServletPath(), "/"+url);
        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Void> getUrl(@PathVariable("id") String id) {
        System.out.println(id);
        String url = urlService.getUrl(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
