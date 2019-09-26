package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void addMenu(MenuModel menu);
    List<MenuModel> findAllMenuByIdRestoran(long idRestoran);
    MenuModel changeMenu(MenuModel menuModel);

    // Method untuk mendapatkan data sebuah Menu berdasarkan id
    Optional<MenuModel> getMenuById(Long id);
}
