package tema;

public class PerecheNumere
{
    private int a;
    private int b;

    public PerecheNumere() {
    }

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


    public boolean esteInFibonacci(int numar) {
        int test1 = 5 * numar * numar + 4;
        int test2 = 5 * numar * numar - 4;

        return estePătratPerfect(test1) || estePătratPerfect(test2);
    }

    public boolean estePătratPerfect(int numar) {
        int sqrt = (int) Math.sqrt(numar);
        return numar == sqrt * sqrt;
    }


    public boolean suntConsecutiveInFibonacci() {
        if (esteInFibonacci(a) && esteInFibonacci(b)) {
            int c= b-a;
            if(esteInFibonacci(c) && (a>c) && (c>0) )
                return true;
        }
        return false;
    }
    public int gcd(int a, int b)
    {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Functie pentru a calcula CMC
    public int lcm()
    {
        return Math.abs(a * b) / gcd(a, b);
    }


    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
