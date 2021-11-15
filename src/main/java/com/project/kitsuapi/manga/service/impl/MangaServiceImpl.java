package com.project.kitsuapi.manga.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.kitsuapi.manga.response.InformacoesManga;
import com.project.kitsuapi.manga.response.InformacoesMangaResponse;
import com.project.kitsuapi.manga.response.Manga;
import com.project.kitsuapi.manga.response.MangaResponse;
import com.project.kitsuapi.manga.response.MangaTrendingResponse;
import com.project.kitsuapi.manga.service.MangaService;
import com.project.kitsuapi.response.KitsuResponse;
import com.project.kitsuapi.util.kitsuApiUtil;

@Service
public class MangaServiceImpl implements MangaService{
	private HttpEntity<String> HTTP_REQUEST_ENTITY;
	private final RestTemplate restTemplate;
	
	@Value("${kitsu-api.client.service-url}")
	String kitsuUrl;
	
	@Value("${kitsu-api.client.service-manga-endpoint}")
	String mangaEndPoint;
    
	@Value("${kitsu-api.client.service-manga-filter}")
	String mangaFilterEndPoint;

	private MangaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
	@Override
	public List<Manga> recuperarMangasMaisPopulares() {
        HTTP_REQUEST_ENTITY = new HttpEntity<>(kitsuApiUtil.headers());
		try {
			return restTemplate
					.exchange(
						kitsuUrl + mangaEndPoint, 
						HttpMethod.GET, HTTP_REQUEST_ENTITY, 
						MangaTrendingResponse.class)
					.getBody()
						.getData()
						.stream()
							.map(KitsuResponse.Data::getAttributes)
							.sorted(Comparator.comparing(Manga::getPopularityRank))
							.collect(Collectors.toList());
		}catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public InformacoesMangaResponse recuperarInformacoesMangas(Integer id) {
	    HTTP_REQUEST_ENTITY = new HttpEntity<>(kitsuApiUtil.headers());
	    var path = kitsuApiUtil.montarUrlManga(kitsuUrl, mangaFilterEndPoint, id);
    	
		return restTemplate
				.exchange(
					path, HttpMethod.GET, HTTP_REQUEST_ENTITY, 
					InformacoesMangaResponse.class)
				.getBody();
	}

	@Override
	public MangaResponse recuperarMangaPorFiltro(Integer id) {
	    HTTP_REQUEST_ENTITY = new HttpEntity<>(kitsuApiUtil.headers());
	    var path = kitsuApiUtil.montarUrlManga(kitsuUrl, mangaEndPoint, id);
    	
		return restTemplate
				.exchange(
					path, HttpMethod.GET, HTTP_REQUEST_ENTITY, 
					MangaResponse.class)
				.getBody();
	}
}
