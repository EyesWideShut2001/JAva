package exemplu;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        List<Punctulet> listaPuncte = new ArrayList<Punctulet>();
        listaPuncte.add(new Punctulet(1, 2));
        listaPuncte.add(new Punctulet(3, 4));

        System.out.println("Punctele sunt: ");
        for (Punctulet punct : listaPuncte)
            System.out.println(punct);

        listaPuncte.remove(0);
        System.out.println("Lista dupa stergerea primului element: ");
        for(Punctulet punct : listaPuncte)
            System.out.println(punct);
    }
}

