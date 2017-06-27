package proxibanque;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;



public class ConseillerClientCrudTest {

	private ConseillerClientCRUDService conseillerCrudService ;
	private Client client;
	
	
	@Before
	public void initialisationDesDonnees(){
		conseillerCrudService = new ConseillerClientCRUDService();
		conseillerCrudService.purge();
		client=new Client("nom", "prenom", "adresse", "email", 1);
		conseillerCrudService.ajout(client);
		
	}
	@After
	public void destructionDesDonnees(){
		client=null;
		conseillerCrudService=null;
	}
	
	@Test
	public void testLectureClient() {
		assertNotNull(conseillerCrudService.lireById(1));
	}
	@Test
	public void testLireProprietesNomClient() {
		assertTrue((conseillerCrudService.lireById(1).getNom() instanceof String));
	}
	@Test
	public void testLireProprietesPrenomClient() {
		assertTrue((conseillerCrudService.lireById(1).getPrenom() instanceof String));
	}
	@Test
	public void testLireProprietesEmailClient() {
		assertTrue((conseillerCrudService.lireById(1).getEmail() instanceof String));
	}

	@Test
	public void testLectureObjetClient() {
		assertNotNull((conseillerCrudService.lireById(1) instanceof Client));
	}
	@Test
	public void testModificationClient() {
		assertTrue((conseillerCrudService.modification(1, new Client("nom", "prenom", "adresse", "email", 1))));
	}
	@Test
	public void testSuppressionClient() {
		assertTrue((conseillerCrudService.suppression(1)));
	}
	@Test
	public void testLireListeClient() {
		assertFalse((conseillerCrudService.lire(1).isEmpty()));
	}
	
	
	
	

}
