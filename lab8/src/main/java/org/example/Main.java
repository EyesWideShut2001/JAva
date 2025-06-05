package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Db.initialize();
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Db.getConnection()) {

            boolean running = true;

            while (running) {
                System.out.println("\nMeniu:");
                System.out.println("1. Adaugă persoană");
                System.out.println("2. Adaugă excursie");
                System.out.println("3. Afișează persoane cu excursii");
                System.out.println("4. Afișează excursii după nume persoană");
                System.out.println("5. Afișează persoane după destinație");
                System.out.println("6. Afișează persoane după anul excursiei");
                System.out.println("7. Șterge excursie");
                System.out.println("8. Șterge persoană");
                System.out.println("0. Ieșire");
                System.out.print("Alege opțiunea: ");

                int opt = Integer.parseInt(sc.nextLine());

                switch (opt) {
                    case 1 -> {
                        System.out.print("Nume: ");
                        String nume = sc.nextLine();
                        System.out.print("Vârstă: ");
                        int varsta = Integer.parseInt(sc.nextLine());
                        try {
                            Operatii.valideazaVarsta(varsta);
                            Operatii.adaugaPersoana(conn, nume, varsta);
                        } catch (ExceptieVarsta e) {
                            System.out.println("Eroare: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.print("ID persoană: ");
                        int idPersoana = Integer.parseInt(sc.nextLine());
                        System.out.print("Destinația: ");
                        String destinatia = sc.nextLine();
                        System.out.print("Anul excursiei: ");
                        int anul = Integer.parseInt(sc.nextLine());
                        try {
                            Operatii.valideazaAnExcursie(anul);
                            Operatii.adaugaExcursie(conn, idPersoana, destinatia, anul);
                        } catch (ExceptieAnExcursie e) {
                            System.out.println("Eroare: " + e.getMessage());
                        }
                    }
                    case 3 -> Operatii.afiseazaPersoaneCuExcursii(conn);
                    case 4 -> {
                        System.out.print("Numele persoanei: ");
                        String nume = sc.nextLine();
                        Operatii.afiseazaExcursiiDupaNume(conn, nume);
                    }
                    case 5 -> {
                        System.out.print("Destinația: ");
                        String destinatia = sc.nextLine();
                        Operatii.afiseazaPersoaneDupaDestinatie(conn, destinatia);
                    }
                    case 6 -> {
                        System.out.print("Anul excursiei: ");
                        int anul = Integer.parseInt(sc.nextLine());
                        Operatii.afiseazaPersoaneDupaAnExcursie(conn, anul);
                    }
                    case 7 -> {
                        System.out.print("ID excursie de șters: ");
                        int idExc = Integer.parseInt(sc.nextLine());
                        Operatii.stergeExcursie(conn, idExc);
                    }
                    case 8 -> {
                        System.out.print("ID persoană de șters: ");
                        int idPers = Integer.parseInt(sc.nextLine());
                        Operatii.stergePersoana(conn, idPers);
                    }
                    case 0 -> {
                        running = false;
                        System.out.println("La revedere!");
                    }
                    default -> System.out.println("Opțiune invalidă.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
