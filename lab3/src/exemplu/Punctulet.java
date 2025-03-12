package exemplu;

class Punctulet
{
    private final int x;
    private final int y;

    public Punctulet(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "x = " + x + ", y = " + y;
    }
}


