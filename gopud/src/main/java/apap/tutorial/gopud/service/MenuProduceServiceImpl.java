package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuProduceServiceImpl implements MenuProduceService {

    private final WebClient webClient;

    @Autowired
    private MenuDb menuDb;

    public MenuProduceServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<MenuModel> retriveListMenu() {
        return menuDb.findAll();
    }

    @Override
    public void deleteMenu(Long id) {
        MenuModel menu = menuDb.findById(id);
        menuDb.delete(menu);
    }

    @Override
    public Mono<String> getStatus(Long id) {
        return null;
    }
}
