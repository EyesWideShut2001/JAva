package tema.lab9.lucrarea9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tema.lab9.lucrarea9.repository.MasinaRepository;

@SpringBootTest
class Lucrarea9ApplicationTests {

    private final MasinaRepository sut;

    public Lucrarea9ApplicationTests(@Autowired MasinaRepository sut) {
        this.sut = sut;
    }

    @BeforeEach
    void setUp() {
        int x = 0;
    }

    @Test
    void contextLoads() {
        int x = 0;
    }

}
