package proxibanque;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.service.ConseillerCompteCRUDService;

public class ConseillerCompteCrudTest {


	private ConseillerCompteCRUDService conseillerCrudService ;
	private Compte compte;
	
	
	@Before
	public void initialisationDesDonnees(){
		conseillerCrudService = new ConseillerCompteCRUDService();
		conseillerCrudService.purge();
		compte=new Compte("courant", 100);
		conseillerCrudService.ajout(compte);
		
	}
	@After
	public void destructionDesDonnees(){
		compte=null;
		conseillerCrudService=null;
	}
	
	@Test
	public void testLectureCompte() {
		assertNotNull(conseillerCrudService.lireById(1));
	}
	@Test
	public void testLireProprietesTypeDeCompteClient() {
		assertTrue((conseillerCrudService.lireById(1).getTypeDeCompte()
				instanceof String));
	}
	@Test
	public void testLectureObjetCompte() {
		assertNotNull((conseillerCrudService.lireById(1) instanceof Compte));
	}
	@Test
	public void testSuppressionCompte() {
		assertTrue((conseillerCrudService.suppression(1)));
	}
	@Test
	public void testLireListeCompte() {
		assertFalse((conseillerCrudService.lire().isEmpty()));
	}
	
	
	
}
