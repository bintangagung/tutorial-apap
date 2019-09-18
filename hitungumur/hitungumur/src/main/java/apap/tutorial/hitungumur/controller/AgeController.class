package apap.tutorial.hitungumur.controller;

import apap.tutorial.hitungumur.model.Age;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class AgeController {

    private String getHitungMundurPage(Optional<LocalDate> birthDate, Model model) {
        if(birthDate.isPresent()) {
            final Age currentAge = new Age(birthDate.get());
            model.addAttribute("age",currentAge);
            model.addAttribute("birthDate", birthDate.get());
        } else {
            model.addAttribute("age", null);
            model.addAttribute("birthDate", "-");
        }
        return "HitungUmurPage.html";
    }

    @GetMapping(value = "/hitung-umur")
    public String hitungUmurWithRequestParam(
            @RequestParam(value = "birthdate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                Optional<LocalDate> birthDate,
            Model model) {
        return getHitungMundurPage(birthDate, model);
    }

    @GetMapping(value = "/hitung-umur/{birthdate}")
    public String hitungUmurWithPathVariable(
            @PathVariable(value = "birthdate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                Optional<LocalDate> birthDate,
            Model model) {
        return  getHitungMundurPage(birthDate, model);
    }

}