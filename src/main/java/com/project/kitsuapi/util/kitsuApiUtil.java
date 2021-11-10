package com.project.kitsuapi.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class kitsuApiUtil {
	public static HttpHeaders headers() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        return headers;
	}
}
