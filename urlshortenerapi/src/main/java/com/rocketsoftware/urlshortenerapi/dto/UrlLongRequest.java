package com.rocketsoftware.urlshortenerapi.dto;

import java.util.Date;

public class UrlLongRequest {
	
	private String longUrl;
	
	private Date expiryDate;

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	

}
