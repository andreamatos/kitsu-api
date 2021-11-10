package com.project.kitsuapi.anime.service;

import java.util.List;

import com.project.kitsuapi.anime.response.AnimeResponse;

public interface AnimeService {
	
	List<AnimeResponse> recuperarAnimesMaisPopulares();

}