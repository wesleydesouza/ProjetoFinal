
drop table if exists musicos;


CREATE TABLE musicos(
id_musicos bigint null AUTO_INCREMENT,
nome  varchar(100) NOT NULL,
instrumento varchar(100) not null,
primary key(id_musicos)
);

