package ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static List <Echipament> listaEchipamente= new ArrayList<Echipament> ();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Scanner scanTxt = new Scanner(new File("src/ex/electronice.txt"));
        String linie;
        while (scanTxt.hasNextLine())
        {
            linie= scanTxt.nextLine();
            String[] separatorLinie = linie.split(", ");
            if(linie.contains("Imprimanta"))
            {

                listaEchipamente.add(new Imprimanta(separatorLinie[0],
                        separatorLinie[1],
                        Double.parseDouble(separatorLinie[2]),
                        separatorLinie[3],
                        _SituatieEchipament.valueOf(separatorLinie[4]),
                        Integer.parseInt(separatorLinie[5]),
                        Integer.parseInt(separatorLinie[6]),
                        Integer.parseInt(separatorLinie[7]),
                        _ModTiparire.valueOf(separatorLinie[8])));
            }
            if(linie.contains("Copiatoare"))
            {
                listaEchipamente.add(new Copiatoare(separatorLinie[0],
                        separatorLinie[1],
                        Double.parseDouble(separatorLinie[2]),
                        separatorLinie[3],
                        _SituatieEchipament.valueOf(separatorLinie[4]),
                        Integer.parseInt(separatorLinie[5]),
                        _FormatCopiere.valueOf(separatorLinie[6])
                       ));
            }
            if(linie.contains("SistemeCalcul"))
            {
                listaEchipamente.add(new SistemeCalcul(separatorLinie[0],
                        separatorLinie[1],
                        Double.parseDouble(separatorLinie[2]),
                        separatorLinie[3],
                        _SituatieEchipament.valueOf(separatorLinie[4]),
                        separatorLinie[5],
                        Integer.parseInt(separatorLinie[6]),
                        Integer.parseInt(separatorLinie[7]),
                        _SistemeOperare.valueOf(separatorLinie[8])
                ));
            }
        }

        System.out.println("Alegeti una din urmatoarele optiuni: ");
        while(true)
        {
            System.out.println("1. Afisarea tuturor echipamentelor.");
            System.out.println("2. Afisarea tuturor imprimantelor.");
            System.out.println("3. Afisarea tuturor copiatoarelor.");
            System.out.println("4. Afisarea tuturor sistemelor de calcul.");
            int opt= scan.nextInt();

            switch(opt)
            {
                case 1:
                    for (var echipament : listaEchipamente)
                        System.out.println(echipament);
                    break;
                case 2:
                    for (var echipament : listaEchipamente)
                    {
                        if (echipament instanceof Imprimanta) {

                            System.out.println(echipament);
                        }
                    }
                    break;
                case 3:
                    for (var echipament : listaEchipamente)
                    {
                        if (echipament instanceof Copiatoare) {

                            System.out.println(echipament);
                        }
                    }
                    break;
                case 4:
                    for (var echipament : listaEchipamente)
                    {
                        if (echipament instanceof SistemeCalcul) {

                            System.out.println(echipament);
                        }
                    }
                    break;
            }



        }
    }
}
