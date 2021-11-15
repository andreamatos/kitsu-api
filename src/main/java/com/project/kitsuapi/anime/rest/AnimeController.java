package com.project.kitsuapi.anime.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.kitsuapi.anime.response.AnimeResponse;
import com.project.kitsuapi.anime.response.EpisodioResponse;
import com.project.kitsuapi.anime.service.AnimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anime")
@Api(tags = "Anime", description = "Endpoint para tratamento dos Animes")
public class AnimeController {

	private final AnimeService animeService;
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna os animes mais populares.")
	@GetMapping(value = "/maisPopulares", produces = APPLICATION_JSON_VALUE)
	public List<AnimeResponse> recuperarAnimesPopulares() {
		return animeService.recuperarAnimesMaisPopulares();
	}
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna informacoes do anime.")
	@GetMapping(value = "/informacoes", produces = APPLICATION_JSON_VALUE)
	public List<AnimeResponse> recuperarInformacoesAnimes(
		@RequestParam(name = "id", required = false) Integer id,
		@RequestParam(name = "Type", required = false) String Type) {
		return animeService.recuperarInformacoesAnimes(id, Type);
	}
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna animes por filtro.")
	@GetMapping(value = "/episodio", produces = APPLICATION_JSON_VALUE)
	public EpisodioResponse recuperarAnimesPorId(
		@RequestParam(name = "id", required = true) Integer id){
		return animeService.recuperarEpisodioAnimesPorId(id);
	}
}
