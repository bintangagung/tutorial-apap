package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.util.List;
import java.util.Optional;

public interface MenuRestService {
    MenuModel createMenu(MenuModel Menu);
    Optional<MenuModel> getMenuByIdMenu(Long idMenu);
    MenuModel changeMenu(Long idMenu, MenuModel menuModel);
    void deleteMenu (Long idMenu);
    List<MenuModel> retriveListMenu();
}
