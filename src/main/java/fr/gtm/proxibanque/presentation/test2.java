package fr.gtm.proxibanque.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;
import fr.gtm.proxibanque.domain.Gerant;
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

		// declaration inst. des classes service
		GerantCRUDService gerantCRUDService = new GerantCRUDService();
		ConseillerClientCRUDService conseillerClientCrudService = new ConseillerClientCRUDService();
		ConseillerCompteCRUDService conseillerCompteCrudService = new ConseillerCompteCRUDService();
		ConseillerService conseillerService = new ConseillerService();

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

		// conseillerClientCrudService.supprimer(1);
		// conseillerCompteCrudService.supprimer(1);
		// conseillerClientCrudService.ajout(client);
		// System.out.println(conseillerClientCrudService.lireClientById(1));
		// gerantCRUDService.supprimer(1);
		System.out.println(conseillerClientCrudService.lire());
		
		//association compte/client
		conseillerService.associationCompte(1, 1);
		System.out.println(conseillerCompteCrudService.lireCompteById(1));
		//
		
		
		System.out.println(conseillerClientCrudService.lire());
		
		System.out.println(conseillerCompteCrudService.lire());
		System.out.println(gerantCRUDService.lire());

		//modification d'info client
		Client clientModifie = new Client("nomMod", "prenomMod", "adresseMod", "emailMod", 3);
		conseillerClientCrudService.modifier(1, clientModifie);
		System.out.println(conseillerClientCrudService.lire());

		//modif d'info conseiller
		Conseiller conseillerModif = new Conseiller("nomModif","prenomModif","loginModif","paswdModif");
		gerantCRUDService.modifier(1, conseillerModif);
		System.out.println(gerantCRUDService.lire());
		
	}

}
