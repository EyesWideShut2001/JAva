CREATE TABLE masina
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    nr_inmatriculare VARCHAR(255),
    marca            VARCHAR(255),
    an_fabricatie    INT,
    culoare          VARCHAR(255),
    kilometri        INT
);

INSERT INTO masina (nr_inmatriculare, marca, an_fabricatie, culoare, kilometri)
VALUES ('B-01XYZ', 'Dacia', 2020, 'Gri', 20000),
       ('B-02ABC', 'BMW', 2019, 'Alb', 15000),
       ('B-03DEF', 'Audi', 2021, 'Negru', 10000),
       ('B-04GHI', 'Mercedes', 2018, 'Albastru', 50000),
       ('B-05JKL', 'Toyota', 2022, 'Roșu', 8000);

