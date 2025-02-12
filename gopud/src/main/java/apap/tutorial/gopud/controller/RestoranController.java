package apap.tutorial.gopud.controller;

import java.util.ArrayList;
import java.util.List;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;


    // URL mapping yang digunakan untuk mengakses halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {

        // Membuat objek RestoranModel
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        model.addAttribute("navbarTitle", "Add Restoran");
        // Return view template
        return "form-add-restoran";
    }

    // URL mapping yang digunakan untuk submit form yang telah anda masukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }


    // URL mapping view
    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
            // Request Parameter untuk dipass
            @RequestParam(value = "idRestoran") Long idRestoran, Model model
            ) {

        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

        List<MenuModel> menuList = menuService.getListMenuOrderByHargaAsc(restoran.getIdRestoran());
        restoran.setListMenu(menuList);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);
        model.addAttribute("navbarTitle", "View Restoran");

        // return view template
        return "view-restoran";
    }

    //API yang digunakan untuk menuju halaman form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        //mengambil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        model.addAttribute("navbarTitle", "Change Restoran");

        return "form-change-restoran";
    }

    //API yang digunakan untuk submit form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);

        return "change-restoran";
    }

    //tampilan viewAll
    @RequestMapping(path = "/restoran/view-all")
    public String viewAll(Model model) {
        List<RestoranModel> restoranList = restoranService.getRestoranList();
        List<RestoranModel> restoranListAlphabet = restoranService.getRestoranListOrderByNama();

        model.addAttribute("restoranList", restoranList);
        model.addAttribute("restoranListAlphabet", restoranListAlphabet);
        model.addAttribute("navbarTitle", "View All Restoran");

        return "view-all-restoran";
    }

    //delete restoran
    @RequestMapping(path = "/restoran/delete/{idRestoran}", method = RequestMethod.GET)
    public String deleteRestoran(@PathVariable Long idRestoran, Model model) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        if (restoran.getListMenu().isEmpty()) {
            restoranService.deleteRestoran(restoran);
            model.addAttribute("restoran", restoran);
            model.addAttribute("navbarTitle", "Delete Restoran");
            return "delete-restoran";
        }
        else {
            model.addAttribute("restoran", restoran);
            model.addAttribute("navbarTitle", "Delete Restoran Gagal");
            return "delete-restoran-gagal";
        }
    }

}
