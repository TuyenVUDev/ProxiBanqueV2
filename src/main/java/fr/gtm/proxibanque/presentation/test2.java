package fr.gtm.proxibanque.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;
import fr.gtm.proxibanque.domain.Gerant;
import fr.gtm.proxibanque.service.AuthentificationService;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;
import fr.gtm.proxibanque.service.ConseillerCompteCRUDService;
import fr.gtm.proxibanque.service.ConseillerService;
import fr.gtm.proxibanque.service.GerantCRUDService;

public class test2 {

	public static void main(String[] args) {

		Conseiller conseiller1 = new Conseiller("nom1", "prenom1", "login1", "pswd1");
		Conseiller conseiller2 = new Conseiller("nom2", "prenom2", "login2", "pswd2");
		Gerant gerant = new Gerant("nom", "prenom", "pswd", "login");
		Compte compteCourant = new Compte("courant", 0);
		Compte compteEpargne = new Compte("epargne", 0);
		Client client1 = new Client("nom1", "prenom1", "adresse1", "email1", 1);
		Client client2 = new Client("nom2", "prenom2", "adresse2", "email2", 1);
		Client client3 = new Client("nom3", "prenom3", "adresse3", "email3", 2);

		// declaration inst. des classes service
		GerantCRUDService gerantCRUDService = new GerantCRUDService();
		ConseillerClientCRUDService conseillerClientCrudService = new ConseillerClientCRUDService();
		ConseillerCompteCRUDService conseillerCompteCrudService = new ConseillerCompteCRUDService();
		ConseillerService conseillerService = new ConseillerService();
		AuthentificationService authentificationService = new AuthentificationService();

		// nettoyage des tables
		gerantCRUDService.purge();
		conseillerClientCrudService.purge();
		conseillerCompteCrudService.purge();

		// ajout d'un conseiller
		gerantCRUDService.ajout(conseiller1);
		gerantCRUDService.ajout(conseiller2);

		// ajout d'un compte courant
		conseillerCompteCrudService.ajout(compteCourant);
		conseillerCompteCrudService.ajout(compteEpargne);
		// ajout d'un client
		conseillerClientCrudService.ajout(client1);
		conseillerClientCrudService.ajout(client2);
		conseillerClientCrudService.ajout(client3);

		// conseillerClientCrudService.supprimer(1);
		// conseillerCompteCrudService.supprimer(1);
		// conseillerClientCrudService.ajout(client);
		// System.out.println(conseillerClientCrudService.lireClientById(1));
		// gerantCRUDService.supprimer(1);
		System.out.println(conseillerClientCrudService.lire(1));

		// association compte/client
		conseillerService.associationCompte(1, 1);
		System.out.println(conseillerCompteCrudService.lireById(1));
		//

		// lecture de tous les comptes
		System.out.println(conseillerCompteCrudService.lire());
		// lecture de tous les conseillers
		System.out.println(gerantCRUDService.lire());

		// modification d'info client
		Client clientModifie = new Client("nomMod", "prenomMod", "adresseMod", "emailMod", 2);
		conseillerClientCrudService.modification(1, clientModifie);
		System.out.println(conseillerClientCrudService.lire(1));

		// modif d'info conseiller
		Conseiller conseillerModif = new Conseiller("nomModif", "prenomModif", "loginModif", "paswdModif");
		gerantCRUDService.modification(1, conseillerModif);
		System.out.println(gerantCRUDService.lire());

		// virement compte à compte
		System.out.println(conseillerCompteCrudService.lire());
		conseillerService.effectuerVirement(1, 2, 100.2);
		System.out.println(conseillerCompteCrudService.lire());

		// validation de la lecture d'une liste de client d'un conseiller unique
		System.out.println(conseillerClientCrudService.lire(1));
		System.out.println(conseillerClientCrudService.lire(2));

		
		//authentification
		System.out.println(authentificationService.testLogin("login2"));
		System.out.println(authentificationService.testPaswd("pswd2"));
		System.out.println(authentificationService.authentification("login2", "pswd2"));
		System.out.println(authentificationService.authentification("login2", "toto"));
		

	}

}
