CREATE TABLE IF NOT EXISTS autor(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(45) NOT NULL,
    BIO VARCHAR(1024) NOT NULL,
    ANO_NASC INT NOT NULL
);