package ex2;

import java.util.Random;

public class Vers {
    private int nrCuv;
    private int nrVocale;
    private String vers;
    private char steluta;
    private float randomNr;
    //nr aleator<0.1 =>majuscule

    public Vers(String vers) {
        this.vers = vers;
        this.nrCuv = initCuv();
        this.nrVocale = initNrVocale();
        this.steluta =initSteluta();
        this.randomNr= initRandomNr();
    }

    Random random = new Random();

    private float initRandomNr() {
        float randomNo = random.nextFloat(1);
        return randomNo;
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

    public char initSteluta()
    {
        if(this.vers.endsWith("er"))
        {
            this.steluta = '*';
        }else {
            this.steluta = 0;
        }


        return steluta;
    }

    @Override
    public String toString()
    {
        if(randomNr<0.1)
            vers=vers.toUpperCase();
        if(steluta=='*')
            return String.format("%s    -are %s cuvinte si %s vocale %c", vers, nrCuv, nrVocale, steluta);
        return String.format("%s    -are %s cuvinte si %s vocale", vers, nrCuv, nrVocale);
    }
}