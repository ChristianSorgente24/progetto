package test.com.milano.businesscomponent.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.Docente;
import com.milano.businesscomponent.utility.StatsUtility;


@TestMethodOrder(OrderAnnotation.class)
class StatsUtilityTest {

	@Test
	@Order(1)
	void testNumeroCorsistiTotali() {
		try {
			StatsUtility st = new StatsUtility();
			int n = st.numeroCorsistiTotali();
			System.out.println("il numero totale di corsisti è: "+n);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test Numero Corsisti Totali");
		}
		
	}
	
	@Test
	@Order(2)
	void testElencoCorsisti() {
		try {
			StatsUtility st = new StatsUtility();
			Corsista[] c = st.elencoCorsisti();
			for(int i=0; i< c.length;i++)
				System.out.println(c[i] + " |");
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test elenco Corsisti");
		}
		
	}
	@Test
	@Order(3)
	void testCorsoPiuFrequentato() {
		try {
			StatsUtility st = new StatsUtility();
			String c = st.corsoPiuFrequentato();
				System.out.println(c);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test corso Piu Frequentato");
		}
		
	}
	@Test
	@Order(4)
	void testDurataMediaCorsi() {
		try {
			StatsUtility st = new StatsUtility();
			double c = st.durataMediaCorsi();
				System.out.println(c);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test durata Media Corsi");
		}
		
	}
	@Test
	@Order(5)
	void testNumCommenti() {
		try {
			StatsUtility st = new StatsUtility();
			for(int i = 1;i <= st.numeroCorsiTotali();i++)
			 System.out.println("numero commenti in codCorso "+i+" :" +st.numCommenti(i));
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test numero Commenti");
		}
		
	}
	@Test
	@Order(6)
	void testDocenteMaxCorsi() {
		try {
			StatsUtility st = new StatsUtility();
			LinkedList<Docente> docenti = st.docenteMaxCorsi(); 
				System.out.println(docenti.toString());
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test docente Max Corsi");
		}
		
	}
	@Test
	@Order(7)
	void testCorsiDisponibili() {
		try {
			StatsUtility st = new StatsUtility();
			LinkedList<Corso> corsi = st.corsiDisponibili();
			for(int i = 0;i< corsi.size();i++)
				System.out.println(corsi.get(i));
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test corsi Disponibili");
		}
		
	}
	@Test
	@Order(8)
	void testNumeroCorsiTotali() {
		try {
			StatsUtility st = new StatsUtility();
			int n = st.numeroCorsiTotali();
				System.out.println("totali corsi: "+n);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Errore test numero Corsi Totali");
		}
		
	}
}
