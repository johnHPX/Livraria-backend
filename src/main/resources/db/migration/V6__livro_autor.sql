CREATE TABLE IF NOT EXISTS livro_autor(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    LIVRO_FK INT,
    AUTOR_FK INT,
    FOREIGN KEY (LIVRO_FK) REFERENCES livro(ID),
    FOREIGN KEY (AUTOR_FK) REFERENCES autor(ID)
);