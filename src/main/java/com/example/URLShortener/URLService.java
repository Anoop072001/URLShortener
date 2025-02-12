package com.example.URLShortener;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class URLService {

    private final UrlShortenerRepository urlShortenerRepository;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;

    public URLService(UrlShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }

    public String shortenURL(String url, String customurl) {
        if(customurl!=null && !customurl.isEmpty()) {
            if(urlShortenerRepository.findByShortUrl(customurl) != null) {
                throw new IllegalArgumentException("URL " + customurl + " is already present in the repository.");
            }
            URLShortener urlShortener = new URLShortener(null, customurl, url);
            urlShortenerRepository.save(urlShortener);
            return customurl;
        }
        else {
            String shortCode;
            do{
                shortCode=generateRandomUrl(SHORT_CODE_LENGTH);
            }while(urlShortenerRepository.findByShortUrl(shortCode) != null);
            URLShortener urlShortener = new URLShortener(null, shortCode, url);
            urlShortenerRepository.save(urlShortener);
            return shortCode;
        }
    }

    private String generateRandomUrl(int shortCodeLength) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortCodeLength; i++) {
            sb.append(ALPHABET.charAt(rand.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
    public String getLongUrl(String shortUrl) {
        URLShortener urlShortener = urlShortenerRepository.findByShortUrl(shortUrl);
        return urlShortener!= null ? urlShortener.getLongUrl() : null;
    }
}
