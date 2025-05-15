package tema.lab9.lucrarea9.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("masina")
public class Masina {
    @Id
    @Column("id")
    private Long id;
    @Column("nr_inmatriculare")
    private String nrInmatriculare;
    @Column("marca")
    private String marca;
    @Column("an_fabricatie")
    private int anFabricatie;
    @Column("culoare")
    private String culoare;
    @Column("kilometri")
    private int kilometri;

    public Masina(String nrInmatriculare,
                  String marca,
                  int anFabricatie,
                  String culoare,
                  int kilometri) {
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.culoare = culoare;
        this.kilometri = kilometri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getKilometri() {
        return kilometri;
    }

    public void setKilometri(int kilometri) {
        this.kilometri = kilometri;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", nrInmatriculare='" + nrInmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", culoare='" + culoare + '\'' +
                ", kilometri=" + kilometri +
                '}';
    }
}
