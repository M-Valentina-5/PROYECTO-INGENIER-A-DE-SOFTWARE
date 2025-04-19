CREATE DATABASE IF NOT EXISTS ProyectoApp;
use ProyectoApp;

CREATE TABLE IF NOT EXISTS Categoria (
id int auto_increment primary key,
nombreCategoria varchar(225) not null,
tipoCategoria enum('INGRESO', 'EGRESO') not null
);

CREATE TABLE IF NOT EXISTS Ingreso (
idI int auto_increment primary key,
categoria_id int not null,
montoI decimal(10,2) not null,
descripcionI text,
fechaI timestamp default current_timestamp,
foreign key (categoria_id) references Categoria(id)
);

CREATE TABLE IF NOT EXISTS Egreso (
idE int auto_increment primary key,
categoria_id int not null,
montoE decimal(10,2) not null,
descripcionE text,
fechaE timestamp default current_timestamp,
foreign key (categoria_id) references Categoria(id)
);

INSERT INTO Categoria (nombreCategoria, tipoCategoria)
values ('Trabajo', 'INGRESO');

INSERT INTO Categoria (nombreCategoria, tipoCategoria)
values ('Alimentación', 'EGRESO');

INSERT INTO Ingreso (categoria_id, montoI, descripcionI)
VALUES (1, 1200000, 'Sueldo del mes');

INSERT INTO Egreso (categoria_id, montoE, descripcionE)
VALUES (2, 65000, 'Mercado de la semana');

SELECT descripcionI, montoI, fechaI, nombreCategoria
FROM Ingreso
JOIN Categoria  ON categoria_id = id;

SELECT descripcionE, montoE, fechaE, nombreCategoria
FROM Egreso
JOIN Categoria  ON categoria_id = id;

