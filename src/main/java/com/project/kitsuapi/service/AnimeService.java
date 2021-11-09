package com.project.kitsuapi.service;

import java.util.List;

import com.project.kitsuapi.response.AnimeResponse;

public interface AnimeService {
	
	List<AnimeResponse> recuperarAnimesMaisPopulares();

}