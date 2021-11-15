package com.project.kitsuapi.anime.service;

import java.util.List;

import com.project.kitsuapi.anime.response.AnimeResponse;
import com.project.kitsuapi.anime.response.EpisodioResponse;

public interface AnimeService {
	
	List<AnimeResponse> recuperarAnimesMaisPopulares();

	List<AnimeResponse> recuperarInformacoesAnimes(Integer id, String type);

	EpisodioResponse recuperarEpisodioAnimesPorId(Integer id);


}