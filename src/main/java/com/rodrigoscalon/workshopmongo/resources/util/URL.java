package com.rodrigoscalon.workshopmongo.resources.util;

import java.net.URLDecoder;

public class URL {
	
	public static String decodeParam(String text) {
		try {
		return URLDecoder.decode(text, "UTF-8");
		
		}catch (UnsuportedEncondingException e) {
			return "";
		}
		
		
	}

}
