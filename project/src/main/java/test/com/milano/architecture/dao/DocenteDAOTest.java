package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
	void test() {
		try {
			 Docente docente = DocenteDAO.getFactory().getByCod(DBAccess.getConnection(), 1567);
			 System.out.println(docente.toString());
			 
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail("errore");
		}
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		conn.close();
	}

}
