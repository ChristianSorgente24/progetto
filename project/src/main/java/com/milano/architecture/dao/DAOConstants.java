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
}
