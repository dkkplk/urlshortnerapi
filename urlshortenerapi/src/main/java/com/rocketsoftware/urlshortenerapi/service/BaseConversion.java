package com.rocketsoftware.urlshortenerapi.service;

import org.springframework.stereotype.Service;

@Service
public class BaseConversion {

	private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private char[] allowedCharacters = allowedString.toCharArray();

	private int base = allowedCharacters.length;

	public String encode(long id) {

		StringBuilder encodedString = new StringBuilder();

		if (id == 0) {
			return String.valueOf(allowedCharacters[0]);
		}

		while (id > 0) {
			encodedString.append(allowedCharacters[(int) (id % base)]);
			id = id / base;
		}

		return encodedString.reverse().toString();
	}

	public long decode(String input) {
		char[] characters = input.toCharArray();
		long length = characters.length;
		long decode = 0;
		int counter = 0;

		for (int i = 0; i < length; i++) {
			decode += allowedString.indexOf(characters[i]) * Math.pow(base, length - counter);
			counter++;
		}

		return decode;
	}
}
