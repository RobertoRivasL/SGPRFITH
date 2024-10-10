drop database if exists prev_riesgo;
create database prev_riesgo;
use prev_riesgo;

CREATE TABLE clientes
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    username        VARCHAR(50) NOT NULL,
    password        varchar(50) NOT NULL,
    nombre          VARCHAR(50) NOT NULL,
    fechaNacimiento VARCHAR(50) NOT NULL,
    tipo            VARCHAR(50) NOT NULL,
    rutCliente      VARCHAR(50) NOT NULL,
    nombres         VARCHAR(50) NOT NULL,
    apellidos       VARCHAR(50) NOT NULL,
    telefono        int         NOT NULL,
    afp             VARCHAR(50) NOT NULL,
    salud           VARCHAR(50) NOT NULL,
    direccion       VARCHAR(50) NOT NULL,
    comuna          VARCHAR(50) NOT NULL,
    edad            int         NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE profesionales
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    username        VARCHAR(50) NOT NULL,
    password        varchar(50) NOT NULL,
    nombre          VARCHAR(50) NOT NULL,
    fechaNacimiento VARCHAR(50) NOT NULL,
    tipo            VARCHAR(50) NOT NULL,
    titulo          VARCHAR(50) NOT NULL,
    fechaIngreso    VARCHAR(50) NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE administrativos
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    username        VARCHAR(50) NOT NULL,
    password        varchar(50) NOT NULL,
    nombre          VARCHAR(50) NOT NULL,
    fechaNacimiento VARCHAR(50) NOT NULL,
    tipo            VARCHAR(50) NOT NULL,
    area            VARCHAR(50) NOT NULL,
    expPrevia       VARCHAR(50) NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE capacitacion
(
    id                 INT PRIMARY KEY AUTO_INCREMENT,
    rutCliente         VARCHAR(50) NOT NULL,
    dia                VARCHAR(50) NOT NULL,
    hora               VARCHAR(50) NOT NULL,
    lugar              VARCHAR(50) NOT NULL,
    duracion           VARCHAR(50) NOT NULL,
    cantidadAsistentes varchar(50) NOT NULL,
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO clientes (username, password, nombre, fechaNacimiento, tipo, rutCliente, nombres, apellidos, telefono, afp,
                      salud, direccion, comuna, edad)
VALUES ('admin', '1234', 'Ganon', '18/11/1994', 'Cliente', '189073526', 'Bastian Alberto', 'Mariangel Adrizola',
        154687951, 'Modelo', 'Fonasa', 'Mars', 'Marispu', 28);
INSERT INTO clientes (username, password, nombre, fechaNacimiento, tipo, rutCliente, nombres, apellidos, telefono, afp,
                      salud, direccion, comuna, edad)
VALUES ('chubaca', '1212', 'Chubita', '12/11/1953', 'Cliente', '16548974', 'Chewb', 'Baccina', 65489789, 'Capital',
        'Isapre', 'Venus', 'Venuspris', 60);
INSERT INTO clientes (username, password, nombre, fechaNacimiento, tipo, rutCliente, nombres, apellidos, telefono, afp,
                      salud, direccion, comuna, edad)
VALUES ('anything', '1313', 'Anyoki', '05/06/1800', 'Cliente', '132654787', 'Any', 'Thing', 654258769, 'Modelo',
        'Fonasa', 'Pluton', 'Plutaster', 34);

INSERT INTO profesionales (username, password, nombre, fechaNacimiento, tipo, titulo, fechaIngreso)
VALUES ('Patricio', '4321', 'Patricio', '07/09/1969', 'Profesional', 'Nutricionista', '2018');
INSERT INTO profesionales (username, password, nombre, fechaNacimiento, tipo, titulo, fechaIngreso)
VALUES ('Ivan', '112233', 'Ivan', '15/05/1988', 'Profesional', 'Programador', '2022');
INSERT INTO profesionales (username, password, nombre, fechaNacimiento, tipo, titulo, fechaIngreso)
VALUES ('Carlitos', '332211', 'Carlos', '14/03/1965', 'Profesional', 'Profesor', '2015');

INSERT INTO administrativos (username, password, nombre, fechaNacimiento, tipo, area, expPrevia)
VALUES ('Roberto', '552211', 'Roberto', '18/07/1959', 'Administrativo', 'CEO', 'Gerente de Google 5 años');
INSERT INTO administrativos (username, password, nombre, fechaNacimiento, tipo, area, expPrevia)
VALUES ('Fernando', '661144', 'Fernando', '04/07/1800', 'Administrativo', 'Seguridad', 'Guardia en el Lider 2 años');
INSERT INTO administrativos (username, password, nombre, fechaNacimiento, tipo, area, expPrevia)
VALUES ('Daniela', '117744', 'Daniela', '19/11/2000', 'Administrativo', 'Gerente',
        'Administradora de grandes tiendas 3 años');

INSERT INTO capacitacion (rutCliente, dia, hora, lugar, duracion, cantidadAsistentes)
VALUES ('18654321', 'lunes', '17:00', 'Bootcamp Programador', '5 Horas', '5');
INSERT INTO capacitacion (rutCliente, dia, hora, lugar, duracion, cantidadAsistentes)
VALUES ('19875632', 'miercoles', '20:00', 'Santiago #2211', '3 Horas', '10');
INSERT INTO capacitacion (rutCliente, dia, hora, lugar, duracion, cantidadAsistentes)
VALUES ('15774332', 'viernes', '08:00', 'Las condes #655', '1 Hora', '20');

