package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.rest.RestoranDetail;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface MenuProduceService {
    List<MenuModel> retriveListMenu();

    void deleteMenu(Long id);

    Mono<String> getStatus(Long id);

}
