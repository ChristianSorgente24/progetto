package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Docente;

class DocenteDAOTest {

	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}
	@Test
	@Order(1)
	void test() {
		try {
			Docente docente = DocenteDAO.getFactory().getByCod(DBAccess.getConnection(), 1567);
			System.out.println(docente.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail("errore");
		}
	}
	
	@Test
	@Order(2)
	void testGetAll() throws ClassNotFoundException, IOException {
		try {
			System.out.println("\nTutti gli elementi:");
			Docente[] docenti = DocenteDAO.getFactory().getAll(DBAccess.getConnection());
			for (Docente x : docenti)
				System.out.println(x.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero getAll fallito");
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		conn.close();
	}

}
