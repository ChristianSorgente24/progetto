package com.milano.businesscomponent.facade;

import java.io.IOException;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.CorsoCorsistaBC;
import com.milano.businesscomponent.DocenteBC;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;
import com.milano.businesscomponent.model.Docente;

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
	public Docente getByCodDocenteFacade(long codDocente) 
			throws DAOException, ClassNotFoundException, IOException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getByCod(codDocente);
	}
	
	public Corso getByCodCorsoFacade(long codCorso) 
			throws DAOException, ClassNotFoundException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getByCodCorso(codCorso);
	}
	
	public Corsista getByCodCorsistaFacade(long codCorsista) 
			throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getByCodCorsista(codCorsista);
	}
	
//--------------------------------------------------------GETALL----------------------------------------------
	
	
	public Corsista[] getAllCorsistaFacade() 
			throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll();
	}
	
	public Corso[] getAllCorsoFacade() 
			throws DAOException, ClassNotFoundException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getAll();
	}
	
	
//--------------------------------------------------------DELETE---------------------------------------------
	
	

	public void deleteCorsoFacade(Corso corso) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoBC cBC = new CorsoBC();
		cBC.deleteCorso(corso);
	}
	

	public void deleteCorsistaFacade(Corsista corsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		cBC.deleteCorsista(corsista);
	}
	

	public void deleteCorsoCorsistaFacade(CorsoCorsista corsoCorsista) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC();
		corsoCorsistaBC.delete(corsoCorsista);
	}
	
	
//--------------------------------------------------------UPDATE---------------------------------------------

	public void updateCorsoFacade(Corso corso) 
			throws ClassNotFoundException, DAOException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.deleteCorso(corso);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
