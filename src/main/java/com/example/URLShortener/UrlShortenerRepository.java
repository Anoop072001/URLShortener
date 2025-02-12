package com.example.URLShortener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<URLShortener,Long> {
    URLShortener findByShortUrl(String shortUrl);
}
