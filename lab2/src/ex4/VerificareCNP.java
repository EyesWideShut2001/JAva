package ex4;

public class VerificareCNP
{
    public boolean VerificareCNP (String cnp)
    {
        int nrCif = cnp.length();
        if (nrCif != 13)                          //verificare numar cifre =13
            return false;

        StringBuilder sb = new StringBuilder(cnp);                 //verificare prima cifra
        char primaCifra = sb.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6')
            return false;


        int suma = 0;
        int cifraControl = 0;
        int[] pondere = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

        for (int i = 0; i < cnp.length() - 1; i++) {
            if (Character.isLetter(cnp.charAt(i)))                    //verificane caractere = cifre
                return false;

            int digit = Character.getNumericValue(cnp.charAt(i));
            suma = suma + pondere[i] * digit;

            cifraControl = suma % 11;                                       //verificare cifra control
            if (sb.charAt(13) != (char) ('0' + cifraControl))
                return false;

        }
        return true;
    }
}
