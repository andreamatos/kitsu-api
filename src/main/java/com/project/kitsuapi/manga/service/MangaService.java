package com.project.kitsuapi.manga.service;

import java.util.List;

import com.project.kitsuapi.manga.response.MangaResponse;

public interface MangaService {
	
	List<MangaResponse> recuperarMangasMaisPopulares();

}