package com.example.demo.Controllers;

import com.example.demo.Entity.Carte;
import com.example.demo.Services.CarteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarteController {

    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    @GetMapping("/lista-carti")
    public String afiseazaCarti(Model model) {
        model.addAttribute("carti", carteService.getToateCartile());
        model.addAttribute("mesaj", "Lista cartilor preluate prin repository.");
        return "carti";
    }

    @PostMapping("/operatii")
    public String operatii(@RequestParam(required = false) String isbn,
                           @RequestParam(required = false) String titlu,
                           @RequestParam(required = false) String autor,
                           @RequestParam(required = false) String adauga,
                           @RequestParam(required = false) String modifica,
                           @RequestParam(required = false) String sterge,
                           @RequestParam(required = false) String filtreaza,
                           @RequestParam(required = false) String lista,
                           Model model) {

        if (lista != null) {
            model.addAttribute("carti", carteService.getToateCartile());
            model.addAttribute("mesaj", "Lista completă a cărților.");
            return "carti";
        }

        String mesaj;
        List<Carte> carti;

        if (adauga != null) {
            mesaj = carteService.adaugaCarte(isbn, titlu, autor);
        } else if (sterge != null) {
            mesaj = carteService.stergeCarte(isbn);
        } else if (modifica != null) {
            mesaj = carteService.modificaCarte(isbn, titlu, autor);
        } else if (filtreaza != null) {
            carti = carteService.filtreazaCartiDupaAutor(autor);
            if (autor == null || autor.isBlank()) {
                mesaj = "Nu a fost introdus niciun autor. Se afiseaza toate cartile.";
            } else {
                mesaj = "Cartile urmatoare apartin autorului " + autor;
            }
            model.addAttribute("carti", carti);
            model.addAttribute("mesaj", mesaj);
            return "carti";
        } else {
            mesaj = "Nicio acțiune selectată.";
        }

        model.addAttribute("carti", carteService.getToateCartile());
        model.addAttribute("mesaj", mesaj);
        return "carti";
    }
}
