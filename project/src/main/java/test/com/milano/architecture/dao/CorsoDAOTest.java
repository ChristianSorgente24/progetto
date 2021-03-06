package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corso;

class CorsoDAOTest {

	@Test
	void test() {
		try {
			Corso corso = new Corso(1, "corso1", new Date(), new Date(), 100.00, "1A", 1567L);
			CorsoDAO.getFactory().create(DBAccess.getConnection(), corso);
			System.out.println("\nCorso Creato");

			Corso c = CorsoDAO.getFactory().getByCod(DBAccess.getConnection(), 1);
			System.out.println("\nGet by Cod:" + c.toString());

			corso.setNomeCorso("Corso 1");
			CorsoDAO.getFactory().update(DBAccess.getConnection(), corso);
			System.out.println("\nCorso Aggiornato");

			System.out.println("\nTutti gli elementi:");
			Corso[] corsi = CorsoDAO.getFactory().getAll(DBAccess.getConnection());
			for (Corso x : corsi)
				System.out.println(x.toString());

			CorsoDAO.getFactory().delete(DBAccess.getConnection(), corso);
			System.out.println("\nCorso Eliminato");

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
