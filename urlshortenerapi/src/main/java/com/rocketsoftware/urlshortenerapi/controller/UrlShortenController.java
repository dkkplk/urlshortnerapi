package com.rocketsoftware.urlshortenerapi.controller;

import java.net.URI;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketsoftware.urlshortenerapi.dto.UrlLongRequest;
import com.rocketsoftware.urlshortenerapi.service.UrlService;

@RestController
@RequestMapping("/api/v1")
public class UrlShortenController {

	private final UrlService urlService;

	public UrlShortenController(UrlService urlService) {

		this.urlService = urlService;
	}

	@PostMapping("create-short")
	public String convertToShortUrl(@RequestBody UrlLongRequest request) {
		return urlService.convertToShortUrl(request);

	}

	@GetMapping(value = "{shorlUrl}")
	@Cacheable(value = "urls", key = "#shortUrl", sync = true)
	public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {

		String url = urlService.getOrignalUrl(shortUrl);

		return ResponseEntity
				.status(HttpStatus.FOUND)
				.location(URI.create(url))
				.build();

	}
}
