package com.lab11.lab.controllers;



import com.lab11.lab.entities.Eveniment;
//import com.lab11.lab.service.EvenimentService;
import com.lab11.lab.services.EvenimentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/evenimente")
public class EvenimentController {

    private final EvenimentService service;

    public EvenimentController(EvenimentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Eveniment> getAll() {
        return service.getAll();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getByLocatie(@PathVariable String locatie) {
        return service.getByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Eveniment> getByData(@PathVariable String data) {
        return service.getByData(LocalDate.parse(data));
    }

    @PostMapping
    public Eveniment create(@RequestBody Eveniment ev) {
        return service.save(ev);
    }

    @PutMapping("/{id}")
    public Eveniment update(@PathVariable Long id, @RequestBody Eveniment ev) {
        return service.update(id, ev).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
