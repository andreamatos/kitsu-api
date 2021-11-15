package com.project.kitsuapi.manga.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.kitsuapi.manga.response.InformacoesMangaResponse;
import com.project.kitsuapi.manga.response.Manga;
import com.project.kitsuapi.manga.response.MangaResponse;
import com.project.kitsuapi.manga.service.MangaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manga")
@Api(tags = "Manga", description = "Endpoint para tratamento dos Mangas")
public class MangaController {

	private final MangaService mangaService;
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna os mangas mais populares.")
	@GetMapping(value = "/maisPopulares", produces = APPLICATION_JSON_VALUE)
	public List<Manga> recuperarMangasPopulares() {
		return mangaService.recuperarMangasMaisPopulares();
	}
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna informacoes do manga.")
	@GetMapping(value = "/informacoes", produces = APPLICATION_JSON_VALUE)
	public InformacoesMangaResponse recuperarInformacoesManga(
		@RequestParam(name = "id", required = true) Integer id) {
		return mangaService.recuperarInformacoesMangas(id);
	}
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna mangas por filtro.")
	@GetMapping(value = "/capitulo", produces = APPLICATION_JSON_VALUE)
	public MangaResponse recuperarMangaPorFiltro(
		@RequestParam(name = "id", required = true) Integer id) {
		return mangaService.recuperarMangaPorFiltro(id);
	}
}
