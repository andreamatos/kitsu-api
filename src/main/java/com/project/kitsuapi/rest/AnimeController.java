package com.project.kitsuapi.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.kitsuapi.response.AnimeResponse;
import com.project.kitsuapi.service.AnimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anime")
@Api(tags = "Anime", description = "Populares")
public class AnimeController {

	private final AnimeService animeService;
	
	@ApiParam(name = "Authorization", type = "header")
    @ApiOperation("Retorna os animes mais populares.")
	@GetMapping(value = "/maisPopulares", produces = APPLICATION_JSON_VALUE)
	public List<AnimeResponse> recuperarAnimesPopulares() {
		return animeService.recuperarAnimesMaisPopulares();
	}
	
}
