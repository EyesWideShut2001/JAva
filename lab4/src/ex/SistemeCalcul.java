package ex;

public class SistemeCalcul extends Echipament
{
    private String tipMonitor;
    private int vitezaProcesor;
    private int capacitateHdd;
    private _SistemeOperare so;

    public SistemeCalcul(String denumire, String nrInventar, double pret, String zonaMagazin, _SituatieEchipament s, String tipMonitor, int vitezaProcesor, int capacitateHdd, _SistemeOperare so) {
        super(denumire, nrInventar, pret, zonaMagazin, s);
        this.tipMonitor = tipMonitor;
        this.vitezaProcesor= vitezaProcesor;
        this.capacitateHdd= capacitateHdd;
        this.so= so;
    }

    public String getTipMonitor() {
        return tipMonitor;
    }

    public void setTipMonitor(String tipMonitor) {
        this.tipMonitor = tipMonitor;
    }

    public int getVitezaProcesor() {
        return vitezaProcesor;
    }

    public void setVitezaProcesor(int vitezaProcesor) {
        this.vitezaProcesor = vitezaProcesor;
    }

    public int getCapacitateHdd() {
        return capacitateHdd;
    }

    public void setCapacitateHdd(int capacitateHdd) {
        this.capacitateHdd = capacitateHdd;
    }

    public _SistemeOperare getSo() {
        return so;
    }

    public void setSo(_SistemeOperare so) {
        this.so = so;
    }

    @Override
    public String toString() {
        return "SistemeCalcul{" +
                super.toString()+
                ", tipMonitor='" + tipMonitor + '\'' +
                ", vitezaProcesor=" + vitezaProcesor +
                ", capacitateHdd=" + capacitateHdd +
                ", so=" + so +
                '}';
    }
}
