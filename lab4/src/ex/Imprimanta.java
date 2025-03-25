package ex;

public class Imprimanta extends Echipament
{
    private int nrPaginiPerMin;
    private int rezolutie;
    private int nrPaginiPerCartus;
    private _ModTiparire tiparine;

    public Imprimanta(String denumire, String nrInventar, double pret, String zonaMagazin, _SituatieEchipament s,int nrPaginiPerMin, int rezolutie, int nrPaginiPerCartus, _ModTiparire tiparire) {
        super(denumire, nrInventar, pret, zonaMagazin, s);
        this.nrPaginiPerMin= nrPaginiPerMin;
        this.rezolutie= rezolutie;
        this.nrPaginiPerCartus= nrPaginiPerCartus;
        this.tiparine=tiparire;
    }

    public int getNrPaginiPerMin() {
        return nrPaginiPerMin;
    }

    public void setNrPaginiPerMin(int nrPaginiPerMin) {
        this.nrPaginiPerMin = nrPaginiPerMin;
    }

    public int getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(int rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getNrPaginiPerCartus() {
        return nrPaginiPerCartus;
    }

    public void setNrPaginiPerCartus(int nrPaginiPerCartus) {
        this.nrPaginiPerCartus = nrPaginiPerCartus;
    }

    public _ModTiparire getTiparine() {
        return tiparine;
    }

    public void setTiparine(_ModTiparire tiparine) {
        this.tiparine = tiparine;
    }

    @Override
    public String toString() {
        return "Imprimanta{" +
                super.toString()+
                "nrPaginiPerMin=" + nrPaginiPerMin +
                ", rezolutie=" + rezolutie +
                ", nrPaginiPerCartus=" + nrPaginiPerCartus +
                ", tiparine=" + tiparine +
                '}';
    }

}
