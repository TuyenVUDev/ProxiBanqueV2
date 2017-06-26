package fr.gtm.proxibanque.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;
import fr.gtm.proxibanque.domain.Gerant;
import fr.gtm.proxibanque.service.ConseillerClientCrudService;
import fr.gtm.proxibanque.service.ConseillerCompteCrudService;
import fr.gtm.proxibanque.service.GerantCRUDService;

public class test2 {

	public static void main(String[] args) {

		
		Conseiller conseiller = new Conseiller("nom", "prenom", "login", "pswd");
		Gerant gerant = new Gerant("nom", "prenom", "pswd", "login");
		Compte compteCourant = new Compte("compte courant", 0);
		Compte compteEpargne = new Compte("compte epargne", 0);
		Client client = new Client("nom", "prenom", "adresse", "email",1);

		

		// declaration inst. des classes service
		GerantCRUDService gerantCRUDService = new GerantCRUDService();
		ConseillerClientCrudService conseillerClientCrudService = new ConseillerClientCrudService();
		ConseillerCompteCrudService conseillerCompteCRUDService=new ConseillerCompteCrudService();
	

		//ajout d'un conseiller
		gerantCRUDService.ajout(conseiller);
		
		//ajout d'un compte courant
		conseillerCompteCRUDService.ajout(compteCourant);
		//ajout d'un client
		conseillerClientCrudService.ajout(client);

		System.out.println(client);
		
		
//		conseillerClientCrudService.ajout(client);
		//	System.out.println(conseillerClientCrudService.lireClientById(1));
		

				
				
						
		// ClientCrudService clientCrudService = new ClientCrudService();
		// clientCrudService.ajout(client);
//		client.setIdConseiller(conseiller.getId());

	}

}
