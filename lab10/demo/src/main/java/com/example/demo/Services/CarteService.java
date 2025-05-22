package com.example.demo.Services;


import com.example.demo.Entity.Carte;
import com.example.demo.Repository.CarteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteService {

    private final CarteRepository carteRepository;

    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public List<Carte> getToateCartile() {
        return carteRepository.findAll();
    }

    public String adaugaCarte(String isbn, String titlu, String autor) {
        if (isbn == null || titlu == null || autor == null ||
                isbn.isBlank() || titlu.isBlank() || autor.isBlank()) {
            return "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!";
        }
        carteRepository.save(new Carte(isbn, titlu, autor));
        return "Adaugare realizata cu succes!";
    }

    public String stergeCarte(String isbn) {
        if (isbn != null && carteRepository.existsById(isbn)) {
            carteRepository.deleteById(isbn);
            return "Cartea cu ISBN-ul " + isbn + " a fost stearsa!";
        }
        return "Nu exista carte cu ISBN-ul specificat.";
    }

    public String modificaCarte(String isbn, String titlu, String autor) {
        if (isbn != null && carteRepository.existsById(isbn)) {
            Carte carte = new Carte(isbn, titlu, autor);
            carteRepository.save(carte);
            return "Cartea cu ISBN-ul " + isbn + " a fost modificata!";
        }
        return "Nu se gaseste nici o carte cu isbnul introdus.";
    }

    public List<Carte> filtreazaCartiDupaAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            return carteRepository.findAll();
        }
        return carteRepository.findByAutor(autor);
    }

}
