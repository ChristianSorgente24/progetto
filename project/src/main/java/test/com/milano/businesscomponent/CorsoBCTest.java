package test.com.milano.businesscomponent;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.model.Corso;

class CorsoBCTest {

	@Test
	void test() {
		try {
			GregorianCalendar inizio = new GregorianCalendar(2002, 1, 15, 0, 0, 0);
			GregorianCalendar fine = new GregorianCalendar(2002, 1, 21, 0, 0, 0);

			Corso corso = new Corso(1, "corso1", inizio.getTime(), fine.getTime(), 100.00, "1A", 1567);
			Corso corso2 = new Corso(2, "corso2", inizio.getTime(), fine.getTime(), 100.00, "1A", 1567);
			CorsoBC cBC = new CorsoBC();

			cBC.createCorso(corso);
			cBC.createCorso(corso2);
			assertNotNull(corso);
			assertNotNull(corso2);
			System.out.println("Corsi Creati");
			
			System.out.println(cBC.getByCodCorso(corso.getCodCorso())); 
			
			/* Lancia IOException
			fine = new GregorianCalendar(2002, 1, 10, 0, 0, 0);
			corso.setDataFineCorso(fine.getTime());
				cBC.updateCorso(corso);*/
				
			/*fine = new GregorianCalendar(2002, 1, 25, 0, 0, 0);
			corso.setDataFineCorso(fine.getTime());

			cBC.updateCorso(corso);
			assertNotNull(corso);*/
			
			Corso[] corsi = cBC.getAll();
			for(Corso x :corsi)
				System.out.println(x.toString());
			
			corsi = cBC.searchCorso("1");
			System.out.println("--Ricerca per stringa");
			for(Corso x :corsi)
				System.out.println(x.toString());
			
			/*cBC.deleteCorso(corso);
			cBC.deleteCorso(corso2);
			System.out.println("Corsi Eliminati");*/

		} catch (IOException exc) {
			System.out.println("Date non valide");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Errore nel test dei corsi");
		}

	}

}
