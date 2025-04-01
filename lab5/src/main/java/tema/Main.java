package tema;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Static list of PerecheNumere
    static List<PerecheNumere> listaPerechi = new ArrayList<>();

    // Method to write the list to a JSON file
    static void scriere(List<PerecheNumere> lista) throws IOException {
        ObjectMapper objM = new ObjectMapper();
        File file = new File("src/main/resources/perechiNr.json");
        objM.writeValue(file, lista);
    }

    // Method to read the list from the JSON file
    static List<PerecheNumere> citire() throws IOException {
        List<PerecheNumere> listaPerechi = new ArrayList<>();
        ObjectMapper objM2 = new ObjectMapper();
        File file = new File("src/main/resources/perechiNr.json");
        listaPerechi = objM2.readValue(file, new TypeReference<List<PerecheNumere>>() {});
        return listaPerechi;
    }

    public static void main(String[] args) throws IOException {
        // Add some PerecheNumere objects to the list

        // Read the data back from the JSON file
        listaPerechi = citire();
        System.out.println("Data read from JSON file: " + listaPerechi);
        for (PerecheNumere pereche : listaPerechi) {
            System.out.println("Numar 1: " + pereche.getA() + ", Numar 2: " + pereche.getB());
        }

            // Write the list to a JSON file
            //scriere(listaPerechi);
            //System.out.println("Data written to JSON file");

        for (PerecheNumere pereche : listaPerechi)
        {
            System.out.println(pereche.suntConsecutiveInFibonacci());
            System.out.println(pereche.lcm());
        }


    }
}
