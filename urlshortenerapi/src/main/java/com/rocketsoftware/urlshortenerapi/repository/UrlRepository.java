package com.rocketsoftware.urlshortenerapi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rocketsoftware.urlshortenerapi.entity.Url;

@Repository
public class UrlRepository {
	
	Map<Long,Url> database = new HashMap<>();

	public Url save(Url url) {
		// TODO Auto-generated method stub
		return null;
	}

	public Url findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
