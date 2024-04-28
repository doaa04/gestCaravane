CREATE DATABASE Caravanes;
Use Caravanes;
CREATE TABLE VILLAGE (
    idVillage INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    adresse VARCHAR(50),
    nombreVisites INT
);

CREATE TABLE MEMBRE (
    idMembre INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50), 
    prenom VARCHAR(50),
    numTelephone INT,
    dateNaissance VARCHAR(50),
    filiere VARCHAR(50),
    ine INT,
    score INT,
    username VARCHAR(50) ,
    password VARCHAR(50) 
);
CREATE TABLE CARAVANE (
    nom VARCHAR(50) PRIMARY KEY,
    dateDebut DATE,
    dateFin DATE,
    idVillage INT  REFERENCES Village(idVillage)
);
CREATE TABLE Participer (
    idCaravane INT REFERENCES CARAVANE(idCaravane),
    idMembre INT REFERENCES MEMBRE(idMembre)
);
CREATE TABLE FAMILLE (
    idFamille INT  AUTO_INCREMENT PRIMARY KEY,
    idVillage INT REFERENCES VILLAGE(idVillage)
);
CREATE TABLE HABITANT (
    idHabitant INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) ,
    prenom VARCHAR(50),
    genre VARCHAR(10),
    dateNaissance DATE,
    numTelephone INT,
    profession VARCHAR(50),
    etatSanitaire VARCHAR(50)
);
CREATE TABLE Appartenir (
    idFamille INT REFERENCES FAMILLE(idFamille),
    idIndividu INT REFERENCES INDIVIDU(idIndividu)
);
CREATE TABLE PAQUET (
    idPaquet INT  AUTO_INCREMENT PRIMARY KEY,
    idFamille INT REFERENCES FAMILLE(idFamille)
);
CREATE TABLE COUVERTURE (
   idArticle int AUTO_INCREMENT PRIMARY KEY,
   idPaquet INT REFERENCES PAQUET(idPaquet)
);
CREATE TABLE HABITS (
    idArticle INT AUTO_INCREMENT PRIMARY KEY,
    taille VARCHAR(50),
    categorie VARCHAR(50),
    genre VARCHAR (50),
    idPaquet INT  REFERENCES PAQUET(idPaquet)
);

CREATE TABLE DENREES_ALIMENTAIRES (
    idArticle INT AUTO_INCREMENT PRIMARY KEY,
    idPaquet INT REFERENCES PAQUET(idPaquet)
);

CREATE TABLE MEDICAMENT (
    idArticle int AUTO_INCREMENT PRIMARY KEY,
    idPaquet INT REFERENCES Paquet(idPaquet)
);
