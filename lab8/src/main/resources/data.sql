CREATE TABLE IF NOT EXISTS persoane (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nume VARCHAR(45),
    varsta INT
    );

CREATE TABLE IF NOT EXISTS excursii (
                                        id_excursie INT AUTO_INCREMENT PRIMARY KEY,
                                        id_persoana INT,
                                        destinatia VARCHAR(100),
    anul INT,
    FOREIGN KEY (id_persoana) REFERENCES persoane(id) ON DELETE CASCADE
    );
