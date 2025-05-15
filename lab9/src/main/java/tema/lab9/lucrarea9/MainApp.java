package tema.lab9.lucrarea9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tema.lab9.lucrarea9.entity.Masina;
import tema.lab9.lucrarea9.repository.MasinaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private final MasinaRepository repository;
    private final JdbcTemplate jdbcTemplate;

    public MainApp(MasinaRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    public void stergereDupaNrInmatriculare(String nrInmatriculare) {
        jdbcTemplate.update("delete from masina where nr_inmatriculare=?", nrInmatriculare);
    }

    void adaugareMasina(Masina masina) {
        repository.save(masina);
    }

    Optional<Masina> cautareMasinaDupaNrInmatriculare(String nrInmatriculare) {
        return repository.findMasinaByNrInmatriculare(nrInmatriculare);
    }

    void afisareMasini() {
        repository.findAll()
                .forEach(masina -> System.out.println(masina));
    }

    @Override
    public void run(String... args) throws Exception {
        //a Adaugare masina BD
        Masina masina = new Masina("1234", "Toyota", 2020, "negru", 10000);
        System.out.println("Masini inainte de insert:");
        afisareMasini();
        adaugareMasina(masina);
        System.out.println("Masini dupa insert:");
        afisareMasini();
        //b sterge prin nr inmatriculare
        System.out.println("Stergem ultima masina dupa nr inmatriculare 1234. Masini dupa delete:");
        stergereDupaNrInmatriculare("1234");
        afisareMasini();
        //c find by nr inmatriculare
        System.out.println("Cautam masina cu nr B-03DEF");
        Optional<Masina> poateMasina = cautareMasinaDupaNrInmatriculare("B-03DEF");
        if (poateMasina.isPresent()) {
            System.out.println("Am gasit masina " + poateMasina.get());
        } else {
            System.out.println("Nu am gasit masina");
        }
        //d stocare in lista
        System.out.println("afisare in lista:");
        List<Masina> list = new ArrayList<>();
        repository.findAll().forEach(m -> {
            System.out.println("Am adaugat in lista masina cu id: %s".formatted(m.getId()));
            list.add(m);
        });
        System.out.println("Gaseste dupa marca, cautam toate masinile cu marca Toyota");
        repository.findAllByMarca("Toyota").forEach(m -> System.out.println("Masina cu id %s are marca Toyota".formatted(m.getId())));
        System.out.println("Nr masinilor sub 100k km");
        System.out.println("S-au gasit %d masini sub 100k km".formatted(repository.countAllByKilometriLessThan(100_000)));
        System.out.println("Lista de masini mai noi de 5 ani:");
        repository.findAllByAnFabricatieGreaterThanEqual(LocalDate.now().getYear() - 5)
                .forEach(m -> System.out.println("Masina cu id %s este mai noua de 5 ani".formatted(m.getId())));
    }
}
