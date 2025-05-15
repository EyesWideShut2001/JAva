package pbInstrumente;

public class InstrumentMuzical
{
    private String producator;
    private int pret;

    public InstrumentMuzical(String producator, int pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public InstrumentMuzical() {
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "InstrumentMuzical{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}
