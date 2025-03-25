package ex;

public class Copiatoare extends Echipament
{
    private int nrPagPerToner;
    private _FormatCopiere format;

    public Copiatoare(String denumire, String nrInventar, double pret, String zonaMagazin, _SituatieEchipament s, int nrPagPerToner, _FormatCopiere format) {
        super(denumire, nrInventar, pret, zonaMagazin, s);
        this.nrPagPerToner = nrPagPerToner;
        this.format= format;
    }

    public int getNrPagPerToner() {
        return nrPagPerToner;
    }

    public void setNrPagPerToner(int nrPagPerToner) {
        this.nrPagPerToner = nrPagPerToner;
    }

    public _FormatCopiere getFormat() {
        return format;
    }

    public void setFormat(_FormatCopiere format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Copiatoare{" +
                super.toString()+
                ", nrPagPerToner=" + nrPagPerToner +
                ", format=" + format +
                '}';
    }
}
