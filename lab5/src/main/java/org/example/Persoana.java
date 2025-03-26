package org.example;

public class Persoana {
    private String nume;
    private int varsta;

    public Persoana() {
    }

    public Persoana(String nume, int varsta) {
        super();
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    @Override
    public String toString() {
        return nume + ", " + varsta;
    }
}