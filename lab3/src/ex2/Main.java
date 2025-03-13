package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/ex2/produse.csv"));
        StringBuilder sb = new StringBuilder();

        while(scan.hasNextLine())
        {
            sb.append(scan.nextLine());
            System.out.println(sb);
        }

    }
}
