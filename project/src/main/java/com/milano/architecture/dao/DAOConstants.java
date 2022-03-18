package com.milano.architecture.dao;

public interface DAOConstants {
	//Select codgenerator
	String SELECT_CORSO_SEQ = "Select CodGeneratorCorso_seq.nextval from dual";
	String SELECT_CORSISTA_SEQ = "Select CodGeneratorCorsista_seq.nextval from dual";
	
	//CRUD corsista
	String SELECT_CORSISTA = "Select * from corsista";
	String UPDATE_CORSISTA = "Update corsista set nomeCorsista = ?, cognomeCorsista = ?, precedentiFormativi = ? where codCorsista = ?";
	String DELETE_CORSISTA = "Delete from corsista where codCorsista = ?";
	String SELECT_CORSISTA_BYCOD = "select * from corsista where codCorsista = ?";
	
	//CRUD docente
	String SELECT_DOCENTE = "Select * from docente";
	String SELECT_DOCENTE_BYCOD = "select * from docente where codDocente = ?";
	
	//CRUD corsocorsista
	String SELECT_CORSOCORSISTA = "Select * from corsocorsista";
	String DELETE_CORSOCORSISTA = "Delete from corsocorsista where codCorso = ? AND codCorsista = ?";
	String SELECT_CORSOCORSISTA_BYCOD = "select * from corsocorsista where codCorso = ? AND codCorsista = ?";
	
	//CRUD corso
	String SELECT_CORSO = "select * from corso";
	String UPDATE_CORSO = "update corso set nomeCorso = ?, dataInizioCorso = ?, dataFineCorso = ?, costoCorso = ?, aulaCorso = ?, codDocente = ? where codCorso = ?";
	String DELETE_CORSO = "delete from corso where codCorso = ?";
	String SELECT_CORSO_BYCOD = "select * from corso where codCorso = ?";

	//login
	String SELECT_ADMINPASS = "Select codAdmin from amministratore where username = ?";
	
	//statistiche
	//N1 Numero corsisti totali.
	String SELECT_TOT_CORSISTI = "select count(codCorsista) from corsista";
    //N2 Nome del corso più frequentato
	String SELECT_CORSO_PIU_FREQUENTATO = "Select codCorso from corsocorsista group by codCorso order by count(*) desc fetch first 1 row only";
	//N3 Data di inizio ultimo corso
	String SELECT_CORSO_RECENTE = "Select MAX(dataInizioCorso) from corso";
	//N4  Durata media dei corsi ( in giorni lavorativi )
	String SELECT_AVG_CORSI = "SELECT  avg((dataFineCorso-dataInizioCorso) -2*FLOOR((dataFineCorso-dataInizioCorso)/7)-DECODE(SIGN(TO_CHAR(dataFineCorso,'D')- TO_CHAR(dataInizioCorso,'D')),-1,2,0)+DECODE(TO_CHAR(dataInizioCorso,'D'),7,1,0)- DECODE(TO_CHAR(dataFineCorso,'D'),7,1,0)) as media FROM corso";
	//N5 Numero di commenti presenti
	String SELECT_NUM_COMMENTI = "SELECT count(commentiCorso) from corsocorsista where codCorso = ?";
	//N6 -> SELECT_CORSISTA Elenco corsisti
	//N7 Docente che può tenere più tipologie di corso
	String SELECT_DOCENTE_MAX_CORSI = "select codDocente from corso group by codDocente	order by count(*) desc";
	//N8 Corsi con posti disponibili
	String SELECT_CORSI_DISPONIBILI = "select codCorso from corsocorsista group by codCorso having count(*) <= 12";
	}
