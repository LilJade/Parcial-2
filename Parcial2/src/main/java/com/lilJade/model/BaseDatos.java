/*

SET GLOBAL TIME_ZONE='-6:00';
-- DROP DATABASE bd_parcial3;
CREATE DATABASE bd_parcial3;
USE bd_parcial3;

CREATE TABLE Tb_Consultas(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50),
apellido VARCHAR(50)
);

CREATE TABLE Tb_Usuario(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
usser VARCHAR(50),
contra VARCHAR(50)
);

INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Maria','Martinez');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Juan','Perez');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Miguel','Ramirez');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Luisa','Guardado');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Enrique','Gonzales');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Carlos','Perez');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Alexa','Amazon');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Fredy','Cartagena');
INSERT INTO Tb_Consultas(nombre, apellido) VALUES('Lucas','Fuentes');

INSERT INTO Tb_Usuario(usser, contra) VALUES('Diaz','12345w');
INSERT INTO Tb_Usuario(usser, contra) VALUES('Duran','contrass');

*/