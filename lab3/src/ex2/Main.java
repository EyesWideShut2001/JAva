package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
   public static List <Produs> ListaProduse = new ArrayList<Produs>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/ex2/produse.csv"));
        //StringBuilder sb = new StringBuilder();


        while(scan.hasNextLine())
        {
            //sb.append(scan.nextLine());

            String linie = scan.nextLine();
            String[] separatorLinie = linie.split(", ");
            //Scanner lineScanner = new Scanner(linie).useDelimiter(", ");
            //ListaProduse.add(new Produs(lineScanner.next(), Double.parseDouble(lineScanner.next()),Integer.parseInt(lineScanner.next()), lineScanner.next()));

            ListaProduse.add(new Produs(separatorLinie[0], Double.parseDouble(separatorLinie[1]), Integer.parseInt(separatorLinie[2]), LocalDate.parse(separatorLinie[3])));


        }

        Scanner scanTastatura = new Scanner(System.in);

        while (true) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate produsele");
            System.out.println("2. Afișează produsele expirate");
            System.out.println("3. Vinde un produs");
            System.out.println("4. Afișează produsele cu prețul minim");
            System.out.println("5. Salvează produsele cu cantitate mai mică decât o valoare dată");
            System.out.println("6. Ieși");
            System.out.print("Alege opțiunea: ");
            int optiune = scanTastatura.nextInt();
            scanTastatura.nextLine();  // Consume new line

            switch (optiune) {
                case 1:
                    for (Produs p : ListaProduse)
                        System.out.println(p);
                    break;
                case 2:
                    for (Produs p : ListaProduse)
                        if(p.getDataExpirare().isBefore(LocalDate.now()))
                            System.out.println(p);
                    break;
                case 3:
                    Scanner scan2Tastatura = new Scanner(System.in);
                    System.out.println("Introduceti produsul pe care doriti sa il vindeti: ");
                    String produs= scan2Tastatura.next();
                    for (Produs p : ListaProduse)
                        if(p.getDenumire() == produs) {
                            if (p.getCantitate() >= 1)
                                p.setCantitate(p.getCantitate() - 1);
                            ListaProduse.remove(p);
                        }

                    break;
                case 4:
                    //afiseazaProduseCuPretMinim();
                    break;
                case 5:
                    //salveazaProduseInFisier(scanner);
                    break;
                case 6:
                    System.out.println("Iesire...");
                    return;
                default:
                    System.out.println("Opțiune invalidă!");

            }
        }

    }
}
