package apap.tutorial.gopud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;
    // URL mapping add
    @RequestMapping("/restoran/add")
    public String add(
            // Request Parameter untuk dipass
            @RequestParam(value = "idRestoran", required = true) String idRestoran,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
            Model model
    ) {
        // Membuat objek RestoranModel
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        // Memanggil service addRestoran
        restoranService.addRestoran(restoran);

        // add variabel nama restoran ke "namaResto" untuk dirender
        model.addAttribute("namaResto", nama);

        // Return view template
        return "add-restoran";
    }

    // URL mapping view
    @RequestMapping("/restoran/view")
    public String view(
            // Request Parameter untuk dipass
            @RequestParam(value = "idRestoran") String idRestoran, Model model
            ) {

        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);
    
        // return view template
        return "view-restoran";
    }

    // URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewAll(Model model) {
        // Mengambil objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        // return view template
        return "viewall-restoran";
    }

//     tambahkan sebuah method view Restoran dengan menggunakan Path Variable
    @GetMapping("/restoran/view/id-restoran/{idRestoran}")
    public String viewWithPathVariable(
            @PathVariable(value = "idRestoran") String idRestoran,
            Model model) {
        return view(idRestoran, model);
    }

//    Tambahkan fitur untuk melakukan update nomorTelepon Restoran berdasarkan idRestoran
    @GetMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    public String updateNomorTelepon(
            @PathVariable(value = "idRestoran") String idRestoran,
            @PathVariable(value = "nomorTelepon") Integer nomorTelepon,
            Model model) {
        // Mengambil objek RestoranModel yang dicari
        RestoranModel resto = restoranService.getRestoranByIdRestoran(idRestoran);
        resto.setNomorTelepon(nomorTelepon);
        // Add model restoran untuk dirender
        model.addAttribute("namaResto", resto);
        model.addAttribute("nomorTelepon", nomorTelepon);
        // return view template
        return "update-restoran";
    }

    //Tambahkan fitur untuk melakukan delete Restoran berdasarkan idRestoran
//    @GetMapping("/restoran/delete/{idRestoran}")
//    public String deleteRestoran(
//            @PathVariable(value = "idRestoran") String idRestoran,
//            Model model) {
//        // Mengambil objek RestoranModel yang dicari
//        RestoranModel resto = restoranService.getRestoranByIdRestoran(idRestoran);
//        // Add model restoran untuk dirender
//        model.addAttribute("idRestoran", idRestoran);
//        // delete restoran
//
//        // return view template
//        return "delete-restoran";
//    }

}
