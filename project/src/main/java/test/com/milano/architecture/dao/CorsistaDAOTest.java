package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corsista;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
			corsista = null;
			System.out.println("Delete funzionante");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Delete corsista fallito");
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			corsista.setNomeCorsista("Paolo");
			corsista.setCognomeCorsista("Rossi");
			corsista.setCodCorsista(1);
			corsista.setPrecedentiFormativi((byte)1);
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Creato corsista");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Creazione corsista fallita");
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetByCod() {
		try {
			corsista.setNomeCorsista("Paolo");
			corsista.setCognomeCorsista("Rossini");
			corsista.setCodCorsista(1);
			corsista.setPrecedentiFormativi((byte)0);
			CorsistaDAO.getFactory().update(conn, corsista);
			System.out.println("Modificato corsista");
			Corsista corsis = CorsistaDAO.getFactory().getByCod(conn, 1);
			System.out.println(corsis.toString());			
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetAll() {
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero getAll fallito");
		}
	}
}
