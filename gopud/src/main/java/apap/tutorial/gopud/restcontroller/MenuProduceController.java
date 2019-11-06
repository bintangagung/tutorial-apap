package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.rest.ResultDetail;
import apap.tutorial.gopud.service.RestoranRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class MenuProduceController {

    @Autowired
    private MenuProduceController menuProduceController;

    @Autowired
    private RestoranRestService restoranRestService;

    @GetMapping(value = "/restoran")
    private Mono<ResultDetail> getRestoranList(@RequestParam(value = "chefRestoran") String chefRestoran){
        return menuProduceController.getRestoranList(chefRestoran);
    }

    @GetMapping(value = "/restoran/{idRestoran}")
    private RestoranModel retriveRestoran(@PathVariable("idRestoran") Long idRestoran) {
        try {
            return restoranRestService.getRestoranByIdRestoran(idRestoran);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Restoran"+String.valueOf(idRestoran)+ "Not Found");
        }
    }

}