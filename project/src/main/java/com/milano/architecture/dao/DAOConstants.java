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
	String UPDATE_CORSOCORSISTA = "Update corsocorsista set codCorso = ? AND codCorsista = ?";
	String DELETE_CORSOCORSISTA = "Delete from corsocorsista where codCorso = ? AND codCorsista = ?";
	String SELECT_CORSOCORSISTA_BYCOD = "select * from corsocorsista where codCorso = ? AND codCorsista = ?";
	
	//CRUD corso
	String SELECT_CORSO = "select * from corso";
	String UPDATE_CORSO = "update corso set nomeCorso = ?, dataInizioCorso = ?, dataFineCorso = ?, costoCorso = ?, commentiCorso = ?, aulaCorso = ?, codDocente = ? where codCorso = ?";
	String DELETE_CORSO = "delete from corso where codCorso = ?";
	String SELECT_CORSO_BYCOD = "select * from corso where codCorso = ?";

	//login
	String SELECT_ADMINPASS = "Select codAdmin from amministratore where username = ?";
	
	//statistiche
	String SELECT_CORSO_RECENTE = "Select MIN(dataInizioCorso) from corso";
	
	//QUERY PER STATISTICHE
	//N2
	String SELECT_DOCENTE_MAX_CORSI = "select codDocente from corso group by codDocente	order by count(*) desc fetch first 1 row only";
	//N7
	String SELECT_CORSI_DISPONIBILI = "select codCorso from corsocorsista group by codCorso having count(*) <= 12";
	//N8
	String SELECT_AVG_CORSI = "SELECT  avg((dataFineCorso-dataInizioCorso) -2*FLOOR((dataFineCorso-dataInizioCorso)/7)-DECODE(SIGN(TO_CHAR(dataFineCorso,'D')- TO_CHAR(dataInizioCorso,'D')),-1,2,0)+DECODE(TO_CHAR(dataInizioCorso,'D'),7,1,0)- DECODE(TO_CHAR(dataFineCorso,'D'),7,1,0)) as media FROM corso";
}
