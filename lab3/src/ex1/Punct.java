package ex1;


 class Punct
{
      int x;
      int y;

    public Punct(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Punct()
    {}

    @Override
    public String toString()
    {
        return "x = " + x + ", y = " + y;
    }
}


