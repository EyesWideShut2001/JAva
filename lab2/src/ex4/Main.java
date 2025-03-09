package ex4;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cate persoane doriti sa introduceti? ");
        int n = scan.nextInt();
        String nume;
        String cnp;
        VerificareCNP verificareCNP = new VerificareCNP();
        for (int i = 0; i < n; i++)
        {
            System.out.println("Introduceti numele: "); nume= scan.next();
            while(true)
            {
                System.out.println("Introduceti cnp: ");
                cnp = scan.next();
                if (verificareCNP.VerificareCNP(cnp))
                    break;
            }

        }

    }
}
