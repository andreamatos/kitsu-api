package com.project.kitsuapi.manga.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<MangaResponse> recuperarMangasPopulares() {
		return mangaService.recuperarMangasMaisPopulares();
	}
	
}
