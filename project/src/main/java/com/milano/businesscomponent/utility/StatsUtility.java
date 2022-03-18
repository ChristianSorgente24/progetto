package com.milano.businesscomponent.utility;

import java.io.IOException;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.model.Corsista;

public class StatsUtility {

	public static int numeroCorsistiTotali() throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll().length;	
	}
	
	public static Corsista[] elencoCorsisti() throws ClassNotFoundException, DAOException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll();
	}
	
}
