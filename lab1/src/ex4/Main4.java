package ex4;

import java.util.Random;

public class Main4
{
    public static void main(String[] args) {
        int a,b;
        Random rand = new Random();
        a= rand.nextInt(30);
        b= rand.nextInt(30);

        int dvMax=1;

        for(int i=1;i<=a;i++)
        {
            if(a % i == 0)
            {
                    if(b%i==0)
                    {
                        dvMax=i;
                    }


            }
        }
        System.out.println("a= " +a);
        System.out.println("b= " +b);
        System.out.println("cmmdc " +dvMax);
    }
}
