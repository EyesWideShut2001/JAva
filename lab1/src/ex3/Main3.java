package ex3;

import java.util.Scanner;

public class Main3
{
    public static void main(String[] args) {
        Scanner scan3 = new Scanner(System.in);
        System.out.print("n= ");
        int n = scan3.nextInt();
        int contor=0;

        for(int i=1;i<=n;i++)
        {
            if(n % i ==0)
            {
                System.out.println(i);
                contor++;
            }
        }
        if(contor==2)
            System.out.println("Numarul este prim!");
    }
}
