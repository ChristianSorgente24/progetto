package com.milano.architecture.dao;

public interface DAOConstants {
	String SELECT_DOCENTE_BYCOD = "select * from docente where codDocente = ?";
	String SELECT_CORSO_SEQ = "Select CodGeneratorCorso_seq.nextval from dual";
	String SELECT_CORSISTA_SEQ = "Select CodGeneratorCorsista_seq.nextval from dual";
	
	String SELECT_CORSISTA = "Select * from corsista";
	String UPDATE_CORSISTA = "Update corsista set nomeCorsista = ?, cognomeCorsista = ?, precedentiFormativi = ? where codCorsista = ?";
	String DELETE_CORSISTA = "Delete from corsista where codCorsista = ?";
	
	String SELECT_DOCENTE = "Select * from docente";

	String SELECT_CORSOCORSISTA = "Select * from corsocorsista";
	String UPDATE_CORSOCORSISTA = "Update corsocorsista set codCorso = ?, codCorsista = ?";
	String DELETE_CORSOCORSISTA = "Delete from corsista where codCorso = ?, codCorsista = ?";
	String SELECT_CORSOCORSISTA_BYCOD = "select * from corsista where codCorsista = ?";
	
	String SELECT_CORSO = "select * from corso";
	String UPDATE_CORSO = "update corso set nomeCorso = ?, dataInizioCorso = ?, dataFineCorso = ?, costoCorso = ?, commentiCorso = ?, aulaCorso = ?, codDocente = ? where codCorso = ?";
	String DELETE_CORSO = "delete from corso where codCorso = ?";
	String SELECT_CORSO_BYCOD = "select * from corso where codCorso = ?";
}
