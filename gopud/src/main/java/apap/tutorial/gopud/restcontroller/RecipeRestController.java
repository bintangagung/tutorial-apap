package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.rest.ResultDetail;
import apap.tutorial.gopud.service.RecipeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RecipeRestController {
    @Autowired
    private RecipeRestService recipeRestService;

    @GetMapping(value = "/recipe")
    private Mono<ResultDetail> getRecipeList(@RequestParam(value = "excludeIngeredients") String excludeIngeredients){
        return recipeRestService.getReceiptList(excludeIngeredients);
    }

}