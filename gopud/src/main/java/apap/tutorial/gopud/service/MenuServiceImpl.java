package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu) {
        menuDb.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public Optional<MenuModel> getMenuById (Long id) {
        return menuDb.findById(id);
    }

    @Override
    public MenuModel changeMenu(MenuModel menuModel) {
        try {
        //mengambil object restoran yang ingin diubah
        MenuModel targetMenu = menuDb.findById(menuModel.getId()).get();

            targetMenu.setNama(menuModel.getNama());
            targetMenu.setHarga(menuModel.getHarga());
            targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
            targetMenu.setDeskripsi(menuModel.getDeskripsi());
            menuDb.save(targetMenu);
            return targetMenu;
        }
        catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public void deleteMenu(MenuModel menu) { menuDb.delete(menu); }

    @Override
    public List<MenuModel> getListMenuOrderByHargaAsc (Long id) {
        return menuDb.findByRestoranIdRestoran(id);
    }

}