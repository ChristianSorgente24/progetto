package com.milano.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.Docente;

public class StatsUtility implements DAOConstants{
	private static Connection conn;
	
	public StatsUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public  int numeroCorsistiTotali() throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll().length;	
	}
	
	public  Corsista[] elencoCorsisti() throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll();
	}
	
	public  String corsoPiuFrequentato() throws DAOException {
		String corsoPiuFreq = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_CORSO_PIU_FREQUENTATO);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
				corsoPiuFreq = rs.getString(1);
			return corsoPiuFreq;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}
	
	public  Date inizioUltimoCorso() throws DAOException {
		Date inizioCorso = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_CORSO_RECENTE);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
				inizioCorso = new java.util.Date(rs.getDate(1).getTime());
			if(inizioCorso != null)
				return inizioCorso;
			System.out.println("nessun corso trovato");
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}
	
	public  double durataMediaCorsi() throws DAOException {
		double giorniAvg = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_AVG_CORSI);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
				giorniAvg = rs.getDouble(1);
			return giorniAvg;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public  int numCommenti(long codCorso) throws DAOException {
		int numCommenti = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_NUM_COMMENTI);
			stmt.setLong(1, codCorso);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
				numCommenti = rs.getInt(1);
			return numCommenti;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public  LinkedList<Docente> docenteMaxCorsi() throws DAOException {
		LinkedList<Docente> docenti = new LinkedList<Docente>(); 
		long codice = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_DOCENTE_MAX_CORSI);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				codice = rs.getLong(1);
				docenti.add(DocenteDAO.getFactory().getByCod(conn, codice));
			}
			return docenti;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public  LinkedList<Corso> corsiDisponibili() throws DAOException {
		LinkedList<Corso> corsi = new LinkedList<Corso>(); 
		long codice = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_CORSI_DISPONIBILI);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				codice = rs.getLong(1);
				corsi.add(CorsoDAO.getFactory().getByCod(conn, codice));
			}
			return corsi;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
