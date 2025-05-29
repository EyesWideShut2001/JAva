package com.lab11.lab.services;

import com.lab11.lab.entities.Eveniment;
//import com.example.evenimente.repository.EvenimentRepository;
import com.lab11.lab.repository.EvenimentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EvenimentService {

    private final EvenimentRepository repository;

    public EvenimentService(EvenimentRepository repository) {
        this.repository = repository;
    }

    public List<Eveniment> getAll() {
        return repository.findAll();
    }

    public List<Eveniment> getByLocatie(String locatie) {
        return repository.findByLocatie(locatie);
    }

    public List<Eveniment> getByData(LocalDate data) {
        return repository.findByData(data);
    }

    public Eveniment save(Eveniment ev) {
        return repository.save(ev);
    }

    public Optional<Eveniment> update(Long id, Eveniment updated) {
        return repository.findById(id).map(ev -> {
            ev.setDenumire(updated.getDenumire());
            ev.setLocatie(updated.getLocatie());
            ev.setData(updated.getData());
            ev.setTimp(updated.getTimp());
            ev.setPretBilet(updated.getPretBilet());
            return repository.save(ev);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
