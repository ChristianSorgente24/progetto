create table amministratore(
nome varchar2(30) not null,
cognome varchar2(30) not null,
username varchar2(30),
codAdmin int not null,
--password
constraint p_username primary key(username));

create table docente(
nomeDocente varchar2(30) not null,
cognomeDocente varchar2(30) not null,
cvDocente varchar2(100) not null,
--url a file
codDocente int,
constraint p_codDocente primary key(codDocente));

create table corso(
codCorso int,
nomeCorso varchar2(30) not null,
dataInizioCorso date not null,
dataFineCorso date not null,
costoCorso number(7,2) not null,
commentiCorso varchar2(100) not null,
--url a file
aulaCorso varchar2(30) not null,
codDocente int,
constraint p_codCorso primary key(codCorso),
constraint f_codDocente foreign key(codDocente) references docente(codDocente));

create table corsista(
nomeCorsista varchar2(30) not null,
cognomeCorsista varchar2(30) not null,
codCorsista int,
precedentiFormativi number(1) not null,
--booleano
constraint codCorsista primary key(codCorsista));

create table corsocorsista(
codCorso int,
codCorsista int,
constraint p_corsocorsista primary key(codCorso,codCorsista),
constraint f_codCorso foreign key(codCorso) references corso(codCorso),
constraint f_codCorsista foreign key(codCorsista) references corsista(codCorsista));

create sequence CodGeneratorCorso_seq;
create sequence CodGeneratorCorsista_seq;