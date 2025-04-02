package pbAngajati;

//import java.time.LocalDate;

import java.time.LocalDate;


public class Angajat
{
    private String nume;
    private String post;
    private LocalDate dataAngajare;
    private float salariu;

    public Angajat() {
    }

    public Angajat(float salariu, LocalDate dataAngajare, String post, String nume) {
        this.salariu = salariu;
        this.dataAngajare = dataAngajare;
        this.post = post;
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(LocalDate dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", dataAngajare=" + dataAngajare +
                ", salariu=" + salariu +
                '}';
    }
}
