package com.project.kitsuapi.manga.service;

import java.util.List;

import com.project.kitsuapi.manga.response.InformacoesManga;
import com.project.kitsuapi.manga.response.InformacoesMangaResponse;
import com.project.kitsuapi.manga.response.Manga;
import com.project.kitsuapi.manga.response.MangaResponse;

public interface MangaService {
	
	List<Manga> recuperarMangasMaisPopulares();

	MangaResponse recuperarMangaPorFiltro(Integer id);

	InformacoesMangaResponse recuperarInformacoesMangas(Integer id);

}