CREATE TABLE corso_di_studio
(
    id SERIAL PRIMARY KEY,
    nome VARCHAR (100), 
    facolta VARCHAR (100), 
    data DATE
)

CREATE TABLE utente
(
    email VARCHAR (300) PRIMARY KEY,
    nome VARCHAR (100),
    cognome VARCHAR (100), 
    id_corsodistudio INT,
    FOREIGN KEY (id_corsodistudio) REFERENCES corso_di_studio(id) ON DELETE CASCADE
)

CREATE TABLE documento
( 
    id SERIAL,
    utente VARCHAR (300),
    nome VARCHAR (200),
    descrizione VARCHAR (1000),
    materia VARCHAR (200),
    contenuto BYTEA,
    PRIMARY KEY (id),
    FOREIGN KEY (utente) REFERENCES utente(email), ON DELETE CASCADE
)