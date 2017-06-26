package fr.gtm.proxibanque.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.dao.ClientCrudDao;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;
import fr.gtm.proxibanque.domain.Gerant;
import fr.gtm.proxibanque.service.ClientCrudService;
import fr.gtm.proxibanque.service.ConseillerCrudService;

public class test2 {

	public static void main(String[] args) {

		Client client = new Client("nom", "prenom", "adresse", "email");
		System.out.println(client);
		Conseiller conseiller = new Conseiller("nom", "prenom", "login", "pswd");
		System.out.println(conseiller);
		Gerant gerant = new Gerant("nom", "prenom", "pswd", "login");
		System.out.println(gerant);
		Compte compteCourant = new Compte("compte courant", 0);
		System.out.println(compteCourant);
		Compte compteEpargne = new Compte("compte epargne", 0);
		System.out.println(compteCourant);


		ConseillerCrudService conseillerCrudService = new ConseillerCrudService();
//		conseillerCrudService.ajout(conseiller);

		// ClientCrudService clientCrudService = new ClientCrudService();
		// clientCrudService.ajout(client);
//		client.setIdConseiller(conseiller.getId());

	}

}
