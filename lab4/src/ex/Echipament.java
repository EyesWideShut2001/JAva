package ex;

abstract class Echipament {
    private String denumire;
    private String nrInventar;
    private double pret;
    private String zonaMagazin;
    private _SituatieEchipament s;

    public Echipament(String denumire, String nrInventar, double pret, String zonaMagazin, _SituatieEchipament s) {
        this.denumire = denumire;
        this.nrInventar = nrInventar;
        this.pret = pret;
        this.zonaMagazin = zonaMagazin;
        this.s = s;
    }

    public String getDenumine() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getNrInventar() {
        return nrInventar;
    }

    public void setNrInventar(String nrInventar) {
        this.nrInventar = nrInventar;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getZonaMagazin() {
        return zonaMagazin;
    }

    public void setZonaMagazin(String zonaMagazin) {
        this.zonaMagazin = zonaMagazin;
    }


    @Override
    public String toString() {
        return
                "denumire='" + denumire + '\'' +
                ", nrInventar='" + nrInventar + '\'' +
                ", pret=" + pret +
                ", zonaMagazin='" + zonaMagazin + '\'' +
                ", s=" + s;
    }
}
