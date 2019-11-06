package apap.tutorial.gopud.service;

import apap.tutorial.gopud.rest.ResultDetail;
import apap.tutorial.gopud.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class RecipeRestServiceImpl implements  RecipeRestService {
    private  final WebClient webClient;

    private final String apiKey = "f21cd6c4390a45c099dd051e8b9cada5";

    public RecipeRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.recipeUrl).build();
    }

    @Override
    public Mono<ResultDetail> getReceiptList(String excludeIngredients) {
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .queryParam("excludeIngeredients", excludeIngredients)
                .queryParam("cuisine", "german")
                .queryParam("apiKey", apiKey).build()).retrieve().bodyToMono(ResultDetail.class);
    }
}