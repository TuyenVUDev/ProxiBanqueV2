package proxibanque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;
import fr.gtm.proxibanque.service.GerantCRUDService;

public class GerantCrudTest {
	private GerantCRUDService gerantCRUDService;
	private Conseiller conseiller;
	
	
	@Before
	public void initialisationDesDonnees(){
		gerantCRUDService = new GerantCRUDService();
		gerantCRUDService.purge();
		Conseiller conseiller=new Conseiller("nom", "prenom", "login", "pswd");
		gerantCRUDService.ajout(conseiller);
		
	}
	@After
	public void destructionDesDonnees(){
		conseiller=null;
		gerantCRUDService=null;
	}
	
	@Test
	public void testLectureConseiller() {
		assertNotNull(gerantCRUDService.lireConseillerById(1));
	}
	@Test
	public void testLireProprietesNomConseiller() {
		assertTrue((gerantCRUDService.lireConseillerById(1).getNom() instanceof String));
	}
	@Test
	public void testLireProprietesPrenomConseiller() {
		assertTrue(((gerantCRUDService.lireConseillerById(1).getPrenom() instanceof String)));
	}
	@Test
	public void testLireProprietesLoginConseiller() {
		assertTrue(((gerantCRUDService.lireConseillerById(1).getLogin() instanceof String)));
	}
	@Test
	public void testLireProprietesPswdConseiller() {
		assertTrue(((gerantCRUDService.lireConseillerById(1).getPswd() instanceof String)));
	}

	@Test
	public void testLectureObjetConseiller() {
		assertNotNull((gerantCRUDService.lireConseillerById(1) instanceof Conseiller));
	}
	@Test
	public void testSuppressionConseiller() {
		assertTrue((gerantCRUDService.suppression(1)));
	}
	@Test
	public void testLireListeConseiller() {
		assertFalse((gerantCRUDService.lire().isEmpty()));
	}
	@Test
	public void testModificationConseiller(){
	assertTrue(gerantCRUDService.modification(1, new Conseiller("nom", "prenom", "login", "pswd")));
	}
	
	
}
