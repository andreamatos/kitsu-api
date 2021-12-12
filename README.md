<p align=center>
  <strong>Kitsu API</strong> <br>
  <img src="https://images7.alphacoders.com/101/1012056.jpg" />
</p>

## API Objective

Manga and anime information that can retrieve from kitsu-api.

## Anime Controller.

```java
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
```

## Manga Controller.

```java
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
```

## API technical specification.

This API was built on Java 11, SgringBoot, Maven and to comunicate using RestTemplate.

Swagger -> http://localhost:8080/swagger-ui/

### Reference.

kitsu-sdk-starter
https://github.com/AppLoidx/kitsu-sdk-starter/
