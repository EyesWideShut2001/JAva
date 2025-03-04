package ex5;

import java.util.Random;

public class Main5
{
    public static boolean estePatratPerfect(int x)
    {
        int s= (int)Math.sqrt(x);
        if (s*s==x)
            return true;
        return false;
    }
    public static void main(String[] args) {

        Random rand2 = new Random();
        int n= rand2.nextInt(20);
        System.out.println("n= "+n );
        int nr1= 5*n*n+4;
        int nr2=5*n*n-4;
        if(estePatratPerfect(nr1) || estePatratPerfect(nr2))
            System.out.println("nr apartine sirului lui fib");


    }
}
