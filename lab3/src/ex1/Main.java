package ex1;

public class Main
{
    public static void main(String[] args)
    {
        Parabola pb1 = new Parabola(2,3,4);
        System.out.println(pb1);

        //• o metodă care calculează și returnează vârful parabolei
        System.out.println("1." +pb1.ReturneazaVarfPb(2,3,4).toString());

        //• o metodă care primește ca și parametru de intrare o parabolă și returneză coordonatele
        //mijlocului segmentului de dreptă care uneşte vârful parabolei curente cu varful
        //parabolei transmisă ca și parametru de intrare
        System.out.println("2." +pb1.returneazaMijlSegment(new Parabola(1, 5, 7)));

        //• o metodă statică ce primeşte ca parametri de intrare două parabole şi calculează
        //coordonatele mijlocului segmentului de dreptă care uneşte vârfurile celor două parabole.
        System.out.println("3." + Parabola.returneazaMijlSegmentStatica(new Parabola(1,2,3), new Parabola(4,5,6)));

        //• o metodă care primește ca și parametru de intrare o parabolă și returneză lungimea
        //segmentului de dreptă care unește vârful parabolei curente cu varful parabolei transmisă
        //ca și parametru de intrare. Se va utiliza metoda statică Math.hypot
        System.out.println("4." + pb1.distantaIntreVârfuri(new Parabola(9,8,7)));

        //• o metodă statică care primește ca și parametri de intrare două parabole și calculează
        //lungimea segmentului de dreapta ce unește vârfurile celor două parabole. Se va utiliza
        //metoda statică Math.hypot
        System.out.println("5." + Parabola.returnLungimeDreaptaDintreVf(new Parabola(5,2,8),new Parabola(1,9,2)));
    }
}
