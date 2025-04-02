package pbAngajati;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main
{
    public static List<Angajat> listaAngajati = new ArrayList<>();

    static List<Angajat> citire() throws IOException
    {
         List<Angajat> lista = new ArrayList<>();
         ObjectMapper objm = new ObjectMapper();
        objm.registerModule(new JavaTimeModule());
        objm.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); // Formatul dorit pentru date
         File file = new File("src/main/resources/angajati.json");
         lista= objm.readValue(file, new TypeReference<List<Angajat>>(){});
         return lista;
    }

    public static void main(String[] args) throws IOException {
        try {
            listaAngajati = citire();
            System.out.println("1. Afișarea listei de angajați: ");
            listaAngajati.forEach(System.out::println);  // Afișează obiectul Angajat

            System.out.println("2. Afișarea angajaților care au salariul peste 2500 RON: ");
            listaAngajati
                    .stream()
                    .filter(angajat->angajat.getSalariu()>2500)
                    .forEach(System.out::println);
                    //    .forEach(angajat -> System.out.println(angajat));

            System.out.println("3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de\n" +
                    "conducere: ");
            List<Angajat> lista = listaAngajati
                    .stream()
                    .filter(angajat -> angajat.getDataAngajare().getMonth()== Month.APRIL)
                    .filter(angajat -> angajat.getDataAngajare().getYear()== Year.now().getValue()-1)
                    .filter(angajat-> angajat.getPost().contains("sef") || angajat.getPost().contains("director"))
                    .collect(Collectors.toList());
            System.out.println(lista);


            System.out.println("4. Afișarea angajaților care nu au funcție de conducere (postul lor nu conține cuvintele\n" +
                    "director sau șef), în ordine descrescătoare a salariilor: ");
            listaAngajati
                    .stream()
                    .filter(angajat-> !angajat.getPost().contains("sef") && !angajat.getPost().contains("director"))
                    .sorted((angajat1, angajat2) -> Double.compare(angajat2.getSalariu(), angajat1.getSalariu()))  // Sortare descrescătoare
                    .forEach(System.out::println);

            System.out.println("5. Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților\n" +
                    "scrise cu majuscule. ");
            List <String> listuta= listaAngajati
                    .stream()
                    .filter(angajat -> angajat.getNume().equals(angajat.getNume().toUpperCase()))
                    .map(Angajat::getNume)
                    .collect(Collectors.toList());
            System.out.println(listuta);


            System.out.println("6. Afișarea salariilor mai mici de 3000 de RON ");
            List <Float> listaSal = listaAngajati
                    .stream()
                    .filter(angajat -> angajat.getSalariu()<3000)
                    .map(Angajat::getSalariu)
                    .collect(Collectors.toList());
            System.out.println(listaSal);

            System.out.println("7. Afișarea datelor primului angajat al firmei.");

            // Determinăm minimul folosind un comparator pentru a compara datele de angajare
            Optional<Angajat> angajatMinim = listaAngajati
                    .stream()
                    .min((angajat1, angajat2) -> angajat1.getDataAngajare().compareTo(angajat2.getDataAngajare()));

            // Verificăm dacă Optional-ul conține o valoare și o afișăm, altfel afișăm un mesaj corespunzător
            angajatMinim.ifPresentOrElse(
                    System.out::println,  // Dacă există o valoare, o afișăm
                    () -> System.out.println("Nu există angajați în lista!"));  // Dacă nu există niciun angajat, afișăm un mesaj











        } catch (IOException e) {
            // Handle any potential file I/O exceptions
            System.err.println("An error occurred while reading the JSON file: " + e.getMessage());
        }
    }
}
