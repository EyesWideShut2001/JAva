package ex2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Produs
{
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data;

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataExpirare() {
        return data;
    }

    public void setDataExpirare(LocalDate dataExpirare) {
        this.data = data;
    }

    public Produs(String denumire, double pret,int bucati, LocalDate data) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate= bucati;
        this.data= data;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", dataExpirare=" + data +
                '}';
    }

}
