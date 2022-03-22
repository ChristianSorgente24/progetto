package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.CorsoCorsistaDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaDAOTest {
	private Connection conn;
	private Corso corso;
	private Corsista corsista;
	private CorsoCorsista corsoCorsista;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corsista = new Corsista();
		
		corso.setAulaCorso("B1");
		corso.setCodCorso(1494);
		corso.setCodDocente(1323L);
		corso.setCostoCorso(500.00);
		corso.setDataFineCorso(new Date());
		corso.setDataInizioCorso(new Date());
		corso.setNomeCorso("Biologia");
		
		corsista.setCodCorsista(1844);
		corsista.setCognomeCorsista("Brambilla");
		corsista.setNomeCorsista("Laura");
		corsista.setPrecedentiFormativi((byte) 1);
		
		
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setCodCorso(corso.getCodCorso());
		corsoCorsista.setCodCorsista(corsista.getCodCorsista());
		
		
	}

	
	@Test
	void testCreate() {
		try {
			//CorsoDAO.getFactory().create(conn, corso);
			CorsistaDAO.getFactory().create(conn, corsista);
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
			
			
			long[] corsiID = CorsoCorsistaDAO.getFactory().getCorsi(conn, corsista.getCodCorsista());
			for(long c: corsiID)
				System.out.println(c);
			
		}catch(DAOException ex) {
			ex.printStackTrace();
			fail("crate corsoCorsista fallito");
		}
		
	}
	
	
	
	
	@AfterEach
	void tearDown() throws Exception {
		try {
			
			conn = DBAccess.getConnection();
			CorsoCorsistaDAO.getFactory().delete(conn, corsoCorsista);
			CorsistaDAO.getFactory().delete(conn, corsista);
			corsoCorsista = null;
			conn.commit();
			System.out.println("corsoCorsista eliminato");
		}catch(ClassNotFoundException | IOException | DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dell\'record");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
