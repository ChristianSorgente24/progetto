package test.com.milano.businesscomponent;

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

			Corso corso = new Corso(1, "corso1", inizio.getTime(), fine.getTime(), 100.00, "Bello", "1A", 1567L);
			CorsoBC cBC = new CorsoBC();

			cBC.createCorso(corso);
			System.out.println("Corso Creato");
			
			System.out.println(cBC.getByCodCorso(1L).toString()); 
			
			/* Lancia IOException
			fine = new GregorianCalendar(2002, 1, 10, 0, 0, 0);
			corso.setDataFineCorso(fine.getTime());
				cBC.updateCorso(corso);*/
				
			fine = new GregorianCalendar(2002, 1, 25, 0, 0, 0);
			corso.setDataFineCorso(fine.getTime());

				cBC.updateCorso(corso);
			
			Corso[] corsi = cBC.getAll();
			for(Corso x :corsi)
				System.out.println(x.toString());
			
			cBC.deleteCorso(corso);
			System.out.println("Corso Eliminato");

		} catch (IOException exc) {
			System.out.println("Date non valide");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
