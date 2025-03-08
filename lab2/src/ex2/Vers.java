package ex2;

public class Vers {
    private int nrCuv;
    private int nrVocale;
    private String vers;
    //*
    //nr aleator<0.1 =>majuscule


    public Vers(int nrCuv, int nrVocale, String vers) {
        this.nrVocale = nrVocale;
        this.nrCuv = nrCuv;
        this.vers = vers;
    }

    public Vers(String vers) {
        this.vers = vers;
        this.nrCuv = initCuv();
        this.nrVocale = initNrVocale();
    }

    public Vers() {

    }

    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
    }

    public int initCuv() {
        String[] words = vers.split("\\s+");
        nrCuv = words.length;
        return nrCuv;
    }

    public int initNrVocale() {
        int n = vers.length();
        nrVocale = 0;
        for (int i = 0; i < n; i++) {
            if (vers.toUpperCase().charAt(i) == 'A' ||
                    vers.toUpperCase().charAt(i) == 'E' ||
                    vers.toUpperCase().charAt(i) == 'I' ||
                    vers.toUpperCase().charAt(i) == 'O' ||
                    vers.toUpperCase().charAt(i) == 'U') {
                nrVocale++;
            }

        }
        return nrVocale;
    }

    @Override
    public String toString() {
        return String.format("%s are %s cuvinte si %s vocale", vers, nrCuv, nrVocale);
    }
}