package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/ex2/cantec_in.txt"));
        PrintStream flux_out = new PrintStream("src/ex2/cantec_out.txt");

        Vers[] vectorVersuri = new Vers[30];
        int contor=0;
        while (scan.hasNextLine()) {
            String vers = scan.nextLine();
            vectorVersuri[contor]=new Vers(vers);
            flux_out.println(vectorVersuri[contor].toString());
            contor++;
        }
    }
}
