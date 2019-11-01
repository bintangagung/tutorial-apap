package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.repository.RestoranDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuRestServiceImpl implements  MenuRestService {

    @Autowired
    private MenuDb menuDb;
    @Autowired
    private RestoranDb restoranDb;

    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDb.save(menu);
    }

    @Override
    public Optional<MenuModel> getMenuByIdMenu(Long idMenu) {
        return menuDb.findById(idMenu);
    }

    @Override
    public MenuModel changeMenu(Long idMenu, MenuModel menuModel) {
        try {
            MenuModel targetMenu = getMenuByIdMenu(menuModel.getId()).get();
            targetMenu.setNama(menuModel.getNama());
            targetMenu.setDeskripsi(menuModel.getDeskripsi());
            targetMenu.setHarga(menuModel.getHarga());
            targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
            menuDb.save(targetMenu);
            return targetMenu;
        } catch (NullPointerException e){
            return null;
        }
    }

    @Override
    public void deleteMenu(Long idMenu) {
        menuDb.delete(getMenuByIdMenu(idMenu).get());
    }

    @Override
    public List<MenuModel> retriveListMenu() {
        return menuDb.findAll();
    }

}