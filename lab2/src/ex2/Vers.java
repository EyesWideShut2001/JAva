package ex2;

public class Vers {
    public int nrCuv;
    public int nrVocale;
    private String vers;
    //*
    //nr aleator<0.1 =>majuscule


    public String getVers() {
        return vers;
    }

    public int NrCUv(String vers) {
        String[] words = vers.split("\\s+");
        nrCuv = words.length;
        return nrCuv;
    }

    public Vers(int nrCuv, int nrVocale, String vers)
{
    this.nrVocale= nrVocale;
    this.nrCuv= nrCuv;
    this.vers=vers;
}

    public Vers()
    {

    }
    public int NrVocale(String vers)
    {
        int n = vers.length();
        nrVocale=0;
        for (int i = 0; i < n; i++)
        {
            if (vers.toUpperCase().charAt(i) == 'A' ||
                    vers.toUpperCase().charAt(i) == 'E' ||
                    vers.toUpperCase().charAt(i) == 'I' ||
                    vers.toUpperCase().charAt(i) == 'O' ||
                    vers.toUpperCase().charAt(i) == 'U')
            {
                nrVocale++;
            }

        }
        return nrVocale;

    }
}
