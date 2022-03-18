package com.milano.businesscomponent.facade;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.CorsoCorsistaBC;
import com.milano.businesscomponent.DocenteBC;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;
import com.milano.businesscomponent.model.Docente;
import com.milano.businesscomponent.utility.StatsUtility;

public class AdminFacade {
private static AdminFacade cF;
	
	private AdminFacade() {
		
	}
	
	
	public static AdminFacade getInstance() {
		if(cF == null)
			cF = new AdminFacade();
		return cF;
	}
	
	
	

//--------------------------------------------------------GETBY----------------------------------------------
	public Docente getByCodDocente(long codDocente) 
			throws DAOException, ClassNotFoundException, IOException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getByCod(codDocente);
	}
	
	public Corso getByCodCorso(long codCorso) 
			throws DAOException, ClassNotFoundException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getByCodCorso(codCorso);
	}
	
	public Corsista getByCodCorsista(long codCorsista) 
			throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getByCodCorsista(codCorsista);
	}
	
//--------------------------------------------------------GETALL----------------------------------------------
	
	
	public Corsista[] getAllCorsista() 
			throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll();
	}
	
	public Corso[] getAllCorso() 
			throws DAOException, ClassNotFoundException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getAll();
	}
	
	
//--------------------------------------------------------DELETE---------------------------------------------
	
	

	public void deleteCorso(Corso corso) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBC = new CorsoBC();
		cBC.deleteCorso(corso);
	}
	

	public void deleteCorsista(Corsista corsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		cBC.deleteCorsista(corsista);
	}
	

	public void deleteCorsoCorsista(CorsoCorsista corsoCorsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC();
		corsoCorsistaBC.delete(corsoCorsista);
	}
	
	
//--------------------------------------------------------UPDATE---------------------------------------------

	public void updateCorso(Corso corso) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.deleteCorso(corso);
	}
	
	public void updateCorsista(Corsista corsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();
		corsistaBC.deleteCorsista(corsista);
	}
	

//--------------------------------------------------------CREATE---------------------------------------------
	
	
	public void createCorsista(Corsista corsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();
		corsistaBC.createCorsista(corsista);
	}
	
	
	
	public void createCorso(Corso corso) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.createCorso(corso);
	}
	
	
	public void createCorsoCorsista(CorsoCorsista corsoCorsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC();
		corsoCorsistaBC.create(corsoCorsista);
	}

	
//--------------------------------------------------------SEARCH---------------------------------------------	
	

	public Corso[] searchCorso(String query)
			throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.searchCorso(query);
	}
	
//--------------------------------------------------------STATS---------------------------------------------	

	public LinkedList<Corso> corsiDisponibili()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.corsiDisponibili();
	}
	
	
	
	
	public LinkedList<Docente> docenteMaxCorsi()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.docenteMaxCorsi();
	}
	
	
	
	public int numeroCommenti(long codCorso)
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.numCommenti(codCorso);
	}
	
	
	public Double durataMediaCorsi()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.durataMediaCorsi();
	}
	
	public Date inizioUltimoCorso()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.inizioUltimoCorso();
	}
	
	
	public String corsoPiuFrequentato()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.corsoPiuFrequentato();
	}
	
	public Corsista[] elencoCorsisti()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.elencoCorsisti();
	}
	
	public int numeroCorsistiTotali()
			throws ClassNotFoundException, DAOException, IOException {
		return StatsUtility.numeroCorsistiTotali();
	}
	
	
}
