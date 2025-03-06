package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/ex2/cantec_in.txt"));
        PrintStream flux_out = new PrintStream("src/ex2/cantec_out.txt");

        String vers;
        Vers versulet = new Vers();
        Vers[] vectorVersuri = new Vers[30];
        int contor=0;
        while (scan.hasNextLine()) {
            vers = scan.nextLine();
            int nrCuv = versulet.NrCUv(vers);
            int nrVocale= versulet.NrVocale(vers);
            String s=vers +" "+ String.valueOf(nrCuv)+" cuvinte si "+String.valueOf(nrVocale)+" vocale";
            vectorVersuri[contor]=new Vers(nrCuv, nrVocale, s);
            flux_out.println(vectorVersuri[contor].getVers());
            contor++;
        }
    }
}
