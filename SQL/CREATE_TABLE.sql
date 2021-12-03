
CREATE TABLE Usuario 
(
	email varchar(40) not null,
	username varchar(30) not null unique,
	password   varchar(40) not null,
	id_plantilla integer generated always as identity unique,
	PRIMARY KEY (email)	
);




CREATE TABLE Jugador 
(
	id_jugador  integer generated always as identity, 
    nombre 		varchar(100) not null,
    equipo      varchar(10) not null,
    posicion 	varchar(15) not null,
    puntos 		integer not null, 
    precio 		bigint not null check (Precio >= 0), 
    pj 			integer not null check (PJ >= 0),  
    media 		float not null, 
    FOREIGN KEY (Equipo) REFERENCES equipo(id),
	PRIMARY KEY (id_jugador)
);

CREATE TABLE Plantilla (
	id_plantilla 	integer not null,
	id_orden 		integer not null check (id_orden>0 AND id_orden<=10),
	id_jugador 		integer,
	UNIQUE (id_plantilla,id_jugador),
	FOREIGN KEY (id_plantilla) REFERENCES Usuario(id_plantilla),
	FOREIGN KEY (id_jugador) REFERENCES Jugador(id_jugador),
	PRIMARY KEY (id_plantilla,id_orden)
);


CREATE TABLE Equipo 
(
	id 		varchar(4) not null, 
	nombre 	varchar(30) not null unique,
	camImag 	varchar(100) not null,
	equipoImag 	varchar(100) not null,
	PRIMARY KEY(id)
);











