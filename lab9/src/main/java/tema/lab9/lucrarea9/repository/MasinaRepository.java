package tema.lab9.lucrarea9.repository;

import org.springframework.data.repository.CrudRepository;
import tema.lab9.lucrarea9.entity.Masina;

import java.util.List;
import java.util.Optional;

public interface MasinaRepository extends CrudRepository<Masina, Long> {
    Optional<Masina> findMasinaByNrInmatriculare(String nrInmatriculare);

    void deleteByNrInmatriculare(String nrInmatriculare);

    void deleteAllByNrInmatriculare(String nrInmatriculare);

    List<Masina> findAllByMarca(String marca);

    Long countAllByKilometriLessThan(int kilometriIsLessThan);

    List<Masina> findAllByAnFabricatieGreaterThanEqual(int anFabricatieIsGreaterThan);
}
