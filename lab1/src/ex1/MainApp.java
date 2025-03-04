package ex1;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);

        System.out.print("a= ");
        int a = scan.nextInt();
        System.out.print("b= ");
        int b= scan.nextInt();
        int perimetru = 2* (a+b);
        int arie = a*b;

        System.out.println("Aria este: "+ arie + ", perimetrul este: "+ perimetru);

        scan.close();
    }

}
