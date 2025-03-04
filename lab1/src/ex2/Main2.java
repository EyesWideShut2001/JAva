package ex2;

import java.io.*;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException{
        int suma=0, vmin=100, vmax=0, contor=0;
        float ma=0;
        Scanner scan2= new Scanner(new File("src/ex2/in.txt"));
        PrintStream flux_out = new PrintStream("src/ex2/out.txt");
        while(scan2.hasNextInt())
        {
            int x= scan2.nextInt();
            contor++;
            suma=suma+x;
            ma=(float)suma/contor;
            if(x<vmin)
                vmin=x;
            if(x>vmax)
                vmax=x;
        }
        System.out.println("Suma este "+ suma);
        System.out.println("Media este "+ ma);
        System.out.println("Valoarea minima este "+ vmin);
        System.out.println("Valoarea maxima este "+ vmax);

        flux_out.println(ma);
    }
}
