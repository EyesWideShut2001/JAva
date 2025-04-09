package pbCarti;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static Map<Integer, Carte> citire() throws IOException {

        ObjectMapper obj = new ObjectMapper();
        obj.registerModule(new JavaTimeModule());


        File file = new File("src/main/resources/carti.json");

        Map<Integer, Carte> cartiMap = obj.readValue(file, obj.getTypeFactory().constructMapType(Map.class, Integer.class, Carte.class));

        return cartiMap;

    }

    static void afisareJson(Map<Integer, Carte> carti) throws IOException {

        ObjectMapper obj = new ObjectMapper();
        obj.registerModule(new JavaTimeModule());


        File file = new File("src/main/resources/carti.json");
        obj.writerWithDefaultPrettyPrinter().writeValue(file,carti);
    }


    static void afisareMap(Map<Integer, Carte> carti) {
        for (var entry : carti.entrySet()) {
            Integer id = entry.getKey();
            Carte carte = entry.getValue();
            System.out.println("ID: " + id + ", " + carte);
        }
    }



    static void stergereDinMap (Map<Integer, Carte> cartiMap, int idDeSters)
    {
        if (cartiMap.containsKey(idDeSters)) {
            cartiMap.remove(idDeSters);
            System.out.println("Cartea cu ID-ul " + idDeSters + " a fost ștearsă.");
        } else {
            System.out.println("Nu există o carte cu ID-ul " + idDeSters);
        }
    }

    static void adaugareCarte(Map<Integer, Carte> cartiMap, int idCarte, Carte carte) {
        Carte carteAdaugata = cartiMap.putIfAbsent(idCarte, carte);
        if (carteAdaugata == null) {
            System.out.println("Cartea cu ID-ul " + idCarte + " a fost adăugată.");
        } else {
            System.out.println("Cartea cu ID-ul " + idCarte + " există deja și nu a fost adăugată.");
        }
    }

    static Set<Carte> cartiYuvalNoahHarari(Map<Integer, Carte> carti) {
        var carticele=carti.values().stream()
                .filter(carte -> "Yuval Noah Harari".equals(carte.autorul()))
                .collect(Collectors.toSet());
        return carticele;
    }




    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> cartiMap = citire();

        // 1. Afișăm colecția Map (cheile și valorile) inferenta tipului prin `var`
        System.out.println("Colecția de cărți:");
        afisareMap(cartiMap);

        // 2. Ștergem o carte după ID (de exemplu, cartea cu ID-ul 3)
        Integer idDeSters = 3;
        stergereDinMap(cartiMap, idDeSters);
        afisareMap(cartiMap);

        // 3. Adăugăm o carte nouă la colecție
        Integer idCarteNoua = 7;
        Carte carteNoua = new Carte( "Titlu Nou", "Autor Nou", LocalDate.of(2025, 1, 1));
        adaugareCarte(cartiMap, idCarteNoua, carteNoua);
        afisareMap(cartiMap);

        //4. Sa se salveze în fișierul JSON modificările făcute asupra colecției
        afisareJson(cartiMap);

        //5. se creeze o colecție Set<Carte> care extrage din colecția Map cărțile autorului
        //Yual Noah Harari.
        System.out.println("5");
        var carticele= cartiYuvalNoahHarari(cartiMap);
        carticele.forEach(c -> System.out.println(c));

        //6. Să se afișeze ordonat după titlul cărți elementele din colecția Set folosind Stream API,
        //expresii Lambda şi referințe la metode.
        System.out.println("6");
        carticele
                .stream()
                .sorted(Comparator.comparing(Carte::titlul))
                .forEach (System.out::println);

        //7. Să se afișeze datele celei mai vechi cărți din colecția Set folosind Stream API şi clasa
        //Optional.
        System.out.println("7");
        var primaCarte = carticele
                .stream()
                .min(Comparator.comparing(Carte::anul));
        System.out.println(primaCarte);

    }


}
