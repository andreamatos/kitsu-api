<p align=center>
  <strong>Kitsu API</strong> <br>
  <img src="https://initiate.alphacoders.com/images/653/cropped-1920-1200-653529.jpg?4405" />
</p>

## Resumo do Projeto

### Objetivo da API

Recuperar informações dos mais diversos animes e mangas

## Especificações de uso do controller de animes

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

### Especificações de uso do controller de mangas

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

### Especificação técnica da API.

A API foi construída com Java 11, SpringBoot, Maven e para comunicação das APIS utilizamos o RestTemplate do springBoot.

Swagger -> http://localhost:8080/swagger-ui/

### Referencias para construção da API.

kitsu-sdk-starter
https://github.com/AppLoidx/kitsu-sdk-starter/
