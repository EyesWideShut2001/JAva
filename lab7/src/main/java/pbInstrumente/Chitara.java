package pbInstrumente;

public class Chitara extends InstrumentMuzical
{
    private int nrCorzi;
    private TipChitara tc;

    public Chitara(int nrCorzi, TipChitara tc) {
        this.nrCorzi = nrCorzi;
        this.tc = tc;
    }

    public Chitara(String producator, int pret, int nrCorzi, TipChitara tc) {
        super(producator, pret);
        this.nrCorzi = nrCorzi;
        this.tc = tc;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }

    public TipChitara getTc() {
        return tc;
    }

    public void setTc(TipChitara tc) {
        this.tc = tc;
    }

    @Override
    public String toString() {
        return "Chitara{" +
                "nrCorzi=" + nrCorzi +
                ", tc=" + tc +
                '}';
    }
}
