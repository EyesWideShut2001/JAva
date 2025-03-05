package ex3;

import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class Main
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti primul string: ");
        String A = scan.next();
        int lungime = A.length() - 1;

        System.out.println("Introduceti al doilea string: ");
        String B = scan.next();

        System.out.println("Introduceti pozitia din primul string in care doriti sa introduceti al doilea string (trebuie sa fie <=) " + lungime + ": ");
        int pozitie = scan.nextInt();
        String result = null;
        if (pozitie < lungime) {
            result = A.substring(0, pozitie) + B + A.substring(pozitie);
            System.out.println("String final: " + result);
        } else {
            System.out.println("Pozitia aleasa este prea mare!");
        }

        System.out.println("Introduceti pozitia din care doriti sa inceapa stergerea: ");
        int pozStergere = scan.nextInt();

        System.out.println("Introduceti nr de caractere care doriti sa se sterga: ");
        int nrCarcatStergere = scan.nextInt();

        StringBuilder sb = new StringBuilder(result);
        sb.delete(pozStergere,pozStergere+nrCarcatStergere);

        System.out.println("Stringul dupa stergere: "+ sb);
    }
}
