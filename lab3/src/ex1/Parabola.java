package ex1;

import static java.lang.Math.pow;

public class Parabola
{
    public int a;
    public int b;
    public int c;
    //pubic Punct varf;

    public Parabola(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c =c;
    }

    public static Punct returneazaMijlSegmentStatica(Parabola pb1, Parabola pb2)
    {
        Punct varf = pb1.ReturneazaVarfPb(pb1.a,pb1.b,pb1.c);
        Punct varf2= pb2.ReturneazaVarfPb(pb2.a, pb2.b, pb2.c);
        return new Punct((varf.x+varf2.x)/2,(varf.y+varf2.y)/2 );
    }

    public static double returnLungimeDreaptaDintreVf(Parabola pb1, Parabola pb2)
    {
        Punct varf1 = pb1.ReturneazaVarfPb(pb1.a,pb1.b,pb1.c);
        Punct varf2= pb2.ReturneazaVarfPb(pb2.a, pb2.b, pb2.c);
        double distanta = Math.hypot(varf2.x - varf1.x, varf2.y - varf1.y);

        return distanta;
    }



    public Punct returneazaMijlSegment(Parabola p)
    {
        Punct varf = ReturneazaVarfPb(a,b,c);
        Punct varf2= ReturneazaVarfPb(p.a, p.b, p.c);
        return new Punct((varf.x+varf2.x)/2,(varf.y+varf2.y)/2 );
    }

    public double distantaIntreVârfuri(Parabola p) {
        Punct varfCurent = ReturneazaVarfPb(this.a, this.b, this.c);
        Punct varfAlteParabola = ReturneazaVarfPb(p.a, p.b, p.c);
        double distanta = Math.hypot(varfAlteParabola.x - varfCurent.x, varfAlteParabola.y - varfCurent.y);

        return distanta;
    }
    public Punct ReturneazaVarfPb (int a, int b, int c)
    {
        Punct varf = new Punct();
        varf.x = -b / (2*a);
        varf.y = (int) (-pow(b,2) + 4*a*c) / 4*a;

        return varf;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("f(x) = ");

        // Gestionăm semnele coeficientului 'a'
        if (a != 0) {
            sb.append(a + "x^2");
        }

        // Adăugăm termenul b, gestionând semnul
        if (b > 0) {
            sb.append(" + " + b + "x");
        } else if (b < 0) {
            sb.append(" - " + Math.abs(b) + "x");
        }

        // Adăugăm termenul c, gestionând semnul
        if (c > 0) {
            sb.append(" + " + c);
        } else if (c < 0) {
            sb.append(" - " + Math.abs(c));
        }

        return sb.toString();
    }


}
