package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("src/ex1/judete_in.txt"));

        String[] a= new String[0];
        int n = 0;

        while(scan.hasNext())
        {
            a= Arrays.copyOf(a,n+1);
            a[n]= scan.next();
            n++;
        }
        Arrays.sort(a);
        System.out.println("Judetele ordonate: ");
        for (String judet : a)
        {
            System.out.println(judet);
        }

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Introduceti judetul cautat: ");
        String jud=scan2.next();

        int pozitie= Arrays.binarySearch(a, jud);

        if(pozitie>=0)
            System.out.println("Pozitia judetului: "+ pozitie);
        if(pozitie<0)
            System.out.println("Judetul nu a fost gasit! ");

        scan.close();
    }
}
