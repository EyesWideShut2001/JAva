package org.example;

import java.sql.*;

public class Operatii {
    public static void adaugaPersoana(Connection conn, String nume, int varsta) throws SQLException
    {
        String sql = "INSERT INTO persoane (nume, varsta) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int rows = ps.executeUpdate();
            System.out.println("Persoană adăugată. Rânduri afectate: " + rows);
        }
    }

    public static void adaugaExcursie(Connection conn, int idPersoana, String destinatia, int anul) throws SQLException
    {
        if (!existaPersoana(conn, idPersoana))
        {
            System.out.println("Persoana cu ID " + idPersoana + " nu există.");
            return;
        }
        String sql = "INSERT INTO excursii (id_persoana, destinatia, anul) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, idPersoana);
            ps.setString(2, destinatia);
            ps.setInt(3, anul);
            int rows = ps.executeUpdate();
            System.out.println("Excursie adăugată. Rânduri afectate: " + rows);
        }
    }

    private static boolean existaPersoana(Connection conn, int id) throws SQLException
    {
        String sql = "SELECT 1 FROM persoane WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery())
            {
                return rs.next();
            }
        }
    }

    public static void afiseazaPersoaneCuExcursii(Connection conn) throws SQLException
    {
        String sqlPers = "SELECT * FROM persoane";
        String sqlExc = "SELECT * FROM excursii WHERE id_persoana = ?";

        try (Statement stmt = conn.createStatement();
             ResultSet rsPers = stmt.executeQuery(sqlPers))
        {

            while (rsPers.next()) {
                int id = rsPers.getInt("id");
                String nume = rsPers.getString("nume");
                int varsta = rsPers.getInt("varsta");
                System.out.println("Persoană: " + nume + " (vârsta: " + varsta + ")");
                try (PreparedStatement psExc = conn.prepareStatement(sqlExc)) {
                    psExc.setInt(1, id);
                    try (ResultSet rsExc = psExc.executeQuery()) {
                        boolean hasExcursii = false;
                        while (rsExc.next()) {
                            hasExcursii = true;
                            System.out.println("  - Excursie: " + rsExc.getString("destinatia") + " în anul " + rsExc.getInt("anul"));
                        }
                        if (!hasExcursii) {
                            System.out.println("  (Fără excursii)");
                        }
                    }
                }
            }
        }
    }



    public static void afiseazaExcursiiDupaNume(Connection conn, String numeCautat) throws SQLException
    {
        String sql = """
        SELECT DISTINCT p.nume, p.varsta
        FROM persoane p
        JOIN excursii e ON p.id = e.id_persoa  -- typo here: should be id_persoana
        WHERE e.destinatia = ?""";

        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, numeCautat);
            try (ResultSet rs = ps.executeQuery())
            {
                boolean gasit = false;
                while (rs.next())
                {
                    gasit = true;
                    System.out.println("Destinație: " + rs.getString("destinatia") + ", An: " + rs.getInt("anul"));
                }
                if (!gasit)
                {
                    System.out.println("Nu s-au găsit excursii pentru persoana cu numele: " + numeCautat);
                }
            }
        }
    }

    public static void afiseazaPersoaneDupaDestinatie(Connection conn, String destinatie) throws SQLException
    {
        String sql =
                """
            SELECT DISTINCT p.nume, p.varsta
                FROM persoane p
            JOIN excursii e ON p.id = e.id_persoa
                  WHERE e.destinatia = ?
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, destinatie);
            try (ResultSet rs = ps.executeQuery())
            {
                boolean gasit = false;
                while (rs.next())
                {
                    gasit = true;
                    System.out.println("Persoană: " + rs.getString("nume") + ", Vârsta: " + rs.getInt("varsta"));
                }
                if (!gasit)
                {
                    System.out.println("Nu există persoane care au vizitat destinația: " + destinatie);
                }
            }
        }
    }

    public static void afiseazaPersoaneDupaAnExcursie(Connection conn, int an) throws SQLException
    {
        String sql = """
            SELECT DISTINCT p.nume,
                p.varsta FROM persoane p
                JOIN excursii e ON p
                .id = e.id_persoana
            WHERE e.anul = ?
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, an);
            try (ResultSet rs = ps.executeQuery())
            {
                boolean gasit = false;
                while (rs.next())
                {
                    gasit = true;
                    System.out.println("Persoană: " + rs.getString("nume") + ", Vârsta: " + rs.getInt("varsta"));
                }
                if (!gasit)
                {
                    System.out.println("Nu există persoane cu excursi în anul: " + an);
                }
            }
        }
    }

     public static void stergeExcursie(Connection conn, int idExcursie) throws SQLException
     {
        String sql = "DELETE FROM excursii WHERE id_excursie = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, idExcursie);
            int rows = ps.executeUpdate();
            System.out.println("Excursie ștearsă. Rânduri afectate: " + rows);
        }
    }

    public static void stergePersoana(Connection conn, int idPersoana) throws SQLException
    {
        String sql = "DELETE FROM persoane WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, idPersoana);
            int rows = ps.executeUpdate();
            System.out.
        println("Persoană ștearsă. Rânduri afectate: " + rows);
        }

    }

    public static void valideazaVarsta(int varsta) throws ExceptieVarsta {
        if (varsta <= 0 || varsta > 120) {
            throw new ExceptieVarsta("Vârsta trebuie să fie un număr pozitiv între 1 și 120.");
        }
    }

    public static void valideazaAnExcursie(int an) throws ExceptieAnExcursie {
        int anulCurent = java.time.Year.now().getValue();
        if (an < 1900 || an > anulCurent) {
            throw new ExceptieAnExcursie("Anul excursiei trebuie să fie între 1900 și " + anulCurent);
        }
    }



}