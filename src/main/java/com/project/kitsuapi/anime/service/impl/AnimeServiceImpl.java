package com.project.kitsuapi.anime.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.kitsuapi.anime.response.AnimeResponse;
import com.project.kitsuapi.anime.response.AnimeTrendingResponse;
import com.project.kitsuapi.anime.response.EpisodioResponse;
import com.project.kitsuapi.anime.service.AnimeService;
import com.project.kitsuapi.response.KitsuResponse;
import com.project.kitsuapi.util.kitsuApiUtil;

@Service
public class AnimeServiceImpl implements AnimeService{
	private HttpEntity<String> HTTP_REQUEST_ENTITY;
	private final RestTemplate restTemplate;
	
	@Value("${kitsu-api.client.service-url}")
	String kitsuUrl;
	
	@Value("${kitsu-api.client.service-anime-endpoint}")
	String animeEndPoint;
	
	@Value("${kitsu-api.client.service-anime-filter}")
	String animeFilterEndpoint;
    
    private AnimeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
	@Override
	public List<AnimeResponse> recuperarAnimesMaisPopulares() {
	    HTTP_REQUEST_ENTITY = new HttpEntity<>(kitsuApiUtil.headers());
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
	}
	
	@Override
	public List<AnimeResponse> recuperarInformacoesAnimes(Integer id, String type) {
	    HTTP_REQUEST_ENTITY = new HttpEntity<>(kitsuApiUtil.headers());
	    var path = kitsuApiUtil.montarUrl(kitsuUrl, animeEndPoint, id, type);
    	
		return restTemplate
				.exchange(
					path,HttpMethod.GET, HTTP_REQUEST_ENTITY, 
					AnimeTrendingResponse.class)
				.getBody()
					.getData()
					.stream()
						.map(KitsuResponse.Data::getAttributes)
						.sorted(Comparator.comparing(AnimeResponse::getPopularityRank))
						.collect(Collectors.toList());
	}
	
	@Override
	public EpisodioResponse recuperarEpisodioAnimesPorId(Integer id) {
        HTTP_REQUEST_ENTITY = new HttpEntity<>(kitsuApiUtil.headers());
			return restTemplate
					.exchange(
						kitsuUrl + animeFilterEndpoint + "/" + id, 
						HttpMethod.GET, HTTP_REQUEST_ENTITY, 
						EpisodioResponse.class)
					.getBody();
	}
	
}
