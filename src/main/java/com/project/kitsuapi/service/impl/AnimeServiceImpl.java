package com.project.kitsuapi.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.kitsuapi.dto.KitsuResponse;
import com.project.kitsuapi.response.AnimeResponse;
import com.project.kitsuapi.response.AnimeTrendingResponse;
import com.project.kitsuapi.service.AnimeService;

@Service
public class AnimeServiceImpl implements AnimeService{
	private HttpEntity<String> HTTP_REQUEST_ENTITY;
	private final RestTemplate restTemplate;
	
	@Value("${kitsu-api.client.service-url}")
	String kitsuUrl;
	
	@Value("${kitsu-api.client.service-endpoint}")
	String animeEndPoint;
    
    private AnimeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
	@Override
	public List<AnimeResponse> recuperarAnimesMaisPopulares() {
        HTTP_REQUEST_ENTITY = new HttpEntity<>(headers());
		try {
			return restTemplate
					.exchange(
						kitsuUrl + animeEndPoint, 
						HttpMethod.GET, HTTP_REQUEST_ENTITY, 
						AnimeTrendingResponse.class)
					.getBody()
						.getData()
						.stream()
							.map(KitsuResponse.Data::getAttributes)
							.sorted(Comparator.comparing(AnimeResponse::getPopularityRank))
							.collect(Collectors.toList());
		}catch (Exception e) {
			throw e;
		}
	}
	
	private HttpHeaders headers() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        return headers;
	}
}
