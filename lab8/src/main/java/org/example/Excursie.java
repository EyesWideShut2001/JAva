package org.example;

public class Excursie {
    private int idExcursie;
    private int idPersoana;
    private String destinatie;
    private int anul;

    public Excursie(int idExcursie, int idPersoana, String destinatie, int anul) {
        this.idExcursie = idExcursie;
        this.idPersoana = idPersoana;
        this.destinatie = destinatie;
        this.anul = anul;
    }

    public Excursie() {
    }

    public int getIdExcursie() {
        return idExcursie;
    }

    public void setIdExcursie(int idExcursie) {
        this.idExcursie = idExcursie;
    }

    public int getIdPersoana() {
        return idPersoana;
    }

    public void setIdPersoana(int idPersoana) {
        this.idPersoana = idPersoana;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }
}

