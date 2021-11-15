package com.project.kitsuapi.util;

import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class kitsuApiUtil {
	public static HttpHeaders headers() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        return headers;
	}

	public static String montarUrl(String kitsuUrl, String animeEndPoint, Integer id, String type) {
		var base = String.format(kitsuUrl + animeEndPoint);
		
		if(Optional.ofNullable(id).isPresent() || 
		   Optional.ofNullable(type).isPresent()) {
			base = String.format(base + "?");
		}

		if(Optional.ofNullable(id).isPresent()){
			base = String.format(base + "id=" + id);
		}
		
		if(Optional.ofNullable(type).isPresent()){
			base = String.format(base + "type=" + type);
		}
		
		return base;
	}
	
	public static String montarUrlManga(String kitsuUrl, String animeEndPoint, Integer id) {
		return String.format(kitsuUrl + animeEndPoint + "/" + id);
	}
}
