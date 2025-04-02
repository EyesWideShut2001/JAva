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
import java.util.DoubleSummaryStatistics;
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
                    .map(Angajat::getSalariu)
                    .filter(salariu -> salariu <3000)
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


            System.out.println("8. Afișarea de statistici referitoare la salariul angajaților. Se va afișa salariul mediu,\n" +
                    "salariul minim şi salariul maxim.");
//            Optional<Float> minimOptional =
//                    listaAngajati
//                            .stream()
//                            .map(Angajat::getSalariu)
//                            .min(Float::compare); // Compară salariile
//            float minim = minimOptional.orElseThrow(() -> new ArithmeticException("Salariul minim nu a fost găsit"));
//
//            Optional<Float> maximOptional=
//                    listaAngajati
//                            .stream()
//                            .map(Angajat::getSalariu)
//                            .max(Float::compare);
//            float maxim=maximOptional.orElseThrow(() -> new ArithmeticException(("Salariul maxim nu a fost găsit")));

            DoubleSummaryStatistics statisticaSalariiAngajati = listaAngajati.stream()
                    .mapToDouble(Angajat::getSalariu) // Convertește salariile într-un stream de tip double
                    .boxed()
                    .collect(Collectors.summarizingDouble(v -> v.doubleValue()));

            System.out.println("Salariul minim: " + statisticaSalariiAngajati.getMin());
            System.out.println("Salariul maxim: " + statisticaSalariiAngajati.getMax());
            System.out.println("Salariul mediu: " + statisticaSalariiAngajati.getAverage());


            System.out.println("9. Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”. ");
            listaAngajati.stream()
                    .filter(a -> a.getNume().contains("Ion"))
                    .findAny()
                    .ifPresentOrElse(
                            e -> System.out.println("L-am gasit pe Ion"),
                            () -> System.out.println("Nu exista vreun Ion"));

            System.out.println("10. Afișarea numărului de persoane care s-au angajat în vara anului precedent. ");
            LocalDate finalDeVara = LocalDate.of(LocalDate.now().getYear() - 1, 9, 1);
            LocalDate inceputDeVara = LocalDate.of(LocalDate.now().getYear() - 1, 6, 1);
            int nrAngajatiVaraTrecuta = (int) listaAngajati.stream()
                    .filter(a -> a.getDataAngajare().isBefore(finalDeVara) && a.getDataAngajare().isAfter(inceputDeVara))
                    .count();
            System.out.println(nrAngajatiVaraTrecuta + " oameni s-au angajat vara trecuta");

        } catch (IOException e) {
            // Handle any potential file I/O exceptions
            System.err.println("An error occurred while reading the JSON file: " + e.getMessage());
        }
    }
}
