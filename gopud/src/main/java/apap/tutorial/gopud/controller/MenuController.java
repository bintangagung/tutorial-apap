package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
    private String addProductFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        MenuModel menu = new MenuModel();
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
//        menu.setRestoran(restoran);
        ArrayList<MenuModel> listMenu = new ArrayList<MenuModel>();
        listMenu.add(menu);
        restoran.setListMenu(listMenu);

        model.addAttribute("restoran", restoran);
        model.addAttribute("menu", menu);
        model.addAttribute("navbarTitle", "Add Menu");

        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    private String addProductSubmit(@ModelAttribute MenuModel menu, Model model) {
        menuService.addMenu(menu);

        model.addAttribute("nama", menu.getNama());
        return "add-menu";
    }

    //API yang digunakan untuk menuju halaman form change menu restoran
    @RequestMapping(value = "/restoran/menu/change/{id}", method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable Long id, Model model) {
        //mengambil existing data restoran
        MenuModel existingMenu = menuService.getMenuById(id).get();
        model.addAttribute("menu", existingMenu);
        model.addAttribute("navbarTitle", "Change Menu");

        return "form-change-menu-restoran";
    }

    //API yang digunakan untuk submit form change menu restoran
    @RequestMapping(value = "/restoran/menu/change/{id}", method = RequestMethod.POST)
    public String changeMenuFormSubmit(@PathVariable Long id, @ModelAttribute MenuModel menu, Model model) {
        MenuModel newMenuData = menuService.changeMenu(menu);
        model.addAttribute("menu", newMenuData);

        return "change-menu-restoran";
    }

    @RequestMapping(value="/restoran/menu/delete", method = RequestMethod.POST)
    private String delete(@ModelAttribute RestoranModel restoran, Model model) {
        for (MenuModel menu : restoran.getListMenu()) {
            menuService.deleteMenu(menu);
        }
        return "delete-menu";
    }

    @RequestMapping(value="/menu/add/{idRestoran}", params="addRow")
    public String addRow(@ModelAttribute RestoranModel restoran, Model model) {
        if(restoran.getListMenu() == null){
            restoran.setListMenu(new ArrayList<MenuModel>());
        }
        restoran.getListMenu().add(new MenuModel());
        model.addAttribute("restoran", restoran);

        return "form-add-menu";
    }

    @RequestMapping(value="/menu/add/{idRestoran}", params="removeRow")
    public String removeRow(@ModelAttribute RestoranModel restoran, HttpServletRequest req, Model model) {
        Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        restoran.getListMenu().remove(rowId.intValue());
        model.addAttribute("restoran", restoran);

        return "form-add-menu";
    }

    @PostMapping(value = "/menu/add/{idRestoran}", params = "submit")
    public String addMenuSubmit(@ModelAttribute RestoranModel restoran, Model model){
        RestoranModel var = restoranService.getRestoranByIdRestoran(restoran.getIdRestoran()).get();
        for(MenuModel menu : restoran.getListMenu()){
            menu.setRestoran(var);
            menuService.addMenu(menu);
        }
        return "add-menu";
    }

}
