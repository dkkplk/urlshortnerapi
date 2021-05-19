package com.rocketsoftware.urlshortenerapi.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.rocketsoftware.urlshortenerapi.dto.UrlLongRequest;
import com.rocketsoftware.urlshortenerapi.entity.Url;
import com.rocketsoftware.urlshortenerapi.repository.UrlRepository;

@Service
public class UrlService {

	private final UrlRepository urlRepository;
	private final BaseConversion baseConversion;

	public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
		this.urlRepository = urlRepository;
		this.baseConversion = baseConversion;
	}

	public String convertToShortUrl(UrlLongRequest request) {

		Url url = new Url();
		url.setLongUrl(request.getLongUrl());
		url.setExpireDate(request.getExpiryDate());
		url.setCreateDate(new Date());
		Url savedUrl = urlRepository.save(url);

		return baseConversion.encode(savedUrl.getId());

	}

	public String getOrignalUrl(String shortUrl) {
		// TODO Auto-generated method stub
		long id = baseConversion.decode(shortUrl);
		Url entity = urlRepository.findById(id);

		return entity.getLongUrl();
	}

}
