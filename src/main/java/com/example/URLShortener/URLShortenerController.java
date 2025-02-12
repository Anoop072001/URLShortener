package com.example.URLShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class URLShortenerController {
    private final URLService urlService;

    public URLShortenerController(URLService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenURL(@RequestParam String LongUrl,@RequestParam(required = false) String customNameUrl) {

        try{
            String shortUrl = urlService.shortenURL(LongUrl, customNameUrl);
            return ResponseEntity.ok("Short URL: https://urlshortener-anoops.up.railway.app/api/"+shortUrl);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getURL(@PathVariable String shortUrl) {
        String longUrl=urlService.getLongUrl(shortUrl);
        if(longUrl==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.status(302).header("Location", longUrl).build();
        }
    }

}
