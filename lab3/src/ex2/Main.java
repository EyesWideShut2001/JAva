package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
        Scanner scan2Tastatura = new Scanner(System.in);
        PrintStream flux_out = new PrintStream("src/ex2/produsePutine.csv");

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
                    //Scanner scan2Tastatura = new Scanner(System.in);
                    System.out.println("Introduceti produsul pe care doriti sa il vindeti: ");
                    String produs = scan2Tastatura.next();
                    System.out.println("Ce cantitate doriti sa vindeti? "); int cantitate= scan2Tastatura.nextInt();
                    Iterator<Produs> iterator = ListaProduse.iterator();
                    while (iterator.hasNext()) {
                        Produs p = iterator.next();
                        if (p.getDenumire().equals(produs)) {
                            if (p.getCantitate() >= cantitate) {
                                p.setCantitate(p.getCantitate() - cantitate);
                                Produs.setIncasari(p.getPret() * cantitate);
                                if (p.getCantitate() == 0)
                                    iterator.remove();
                            } else System.out.println("Nu este suficient pe stoc");

                        }
                    }
                break;
                case 4:
                    Produs prodCuPretMin = new Produs( 1000.9);
                    for (Produs p : ListaProduse)
                    {
                        if(p.getPret()< prodCuPretMin.getPret())
                        {
                            prodCuPretMin = p;
                        }
                    }
                    System.out.println("Produsele cu cel mai mic pret sunt: ");
                    for (Produs p: ListaProduse)
                    {
                        if(p.getPret()==prodCuPretMin.getPret())
                            System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.println("Introduceti cantitatea minima: ");
                    int nr=scan2Tastatura.nextInt();
                    for (Produs p : ListaProduse)
                        if(p.getCantitate()<nr)
                        // ListaProdusePutine. add (p);
                            flux_out.println(p);
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
