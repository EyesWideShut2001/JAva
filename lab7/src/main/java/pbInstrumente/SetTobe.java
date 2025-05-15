package pbInstrumente;

public class SetTobe extends InstrumentMuzical
{
    private TipTobe tt;
    private  int nrTobe;
    private int nrCinele;


    public SetTobe(String producator, int pret, TipTobe tt, int nrTobe, int nrCinele) {
        super(producator, pret);
        this.tt = tt;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    public SetTobe(TipTobe tt, int nrTobe, int nrCinele) {
        this.tt = tt;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    public TipTobe getTt() {
        return tt;
    }

    public void setTt(TipTobe tt) {
        this.tt = tt;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public void setNrTobe(int nrTobe) {
        this.nrTobe = nrTobe;
    }

    public int getNrCinele() {
        return nrCinele;
    }

    public void setNrCinele(int nrCinele) {
        this.nrCinele = nrCinele;
    }

    @Override
    public String toString() {
        return "SetTobe{" +
                "tt=" + tt +
                ", nrTobe=" + nrTobe +
                ", nrCinele=" + nrCinele +
                '}';
    }
}
