package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.gtm.proxibanque.dao.ConseillerClientCRUDDao;
import fr.gtm.proxibanque.dao.ConseillerCompteCRUDDao;

public class ConseillerCompteCRUDService implements CRUDInterface {

	ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();
	ConseillerClientCRUDService conseillerClientCRUDService = new ConseillerClientCRUDService();

	/**
	 * methoude d'ajout d'un compte, retourne un boolean
	 * 
	 * 
	 * @param compte
	 * @return
	 */
	public boolean ajout(Compte compte) {
		conseillerCompteCRUDDao.ajout(compte);
		return true;
	}

	/**
	 * methode retournant une liste de tous les comptes
	 * 
	 * @return
	 */
	public ArrayList<Compte> lire() {
		return conseillerCompteCRUDDao.lireListe();

	};

	/**
	 * methode retournant unun compte d'apres un id
	 * 
	 * @param id
	 * @return
	 */
	public Compte lireById(int id) {
		return conseillerCompteCRUDDao.lireById(id);
	}

	/**
	 * methode pour vider la table des comptes en reinitialisant l'auto
	 * incrementation
	 */
	public boolean purge() {
		return conseillerCompteCRUDDao.purgeTable();
	}

	/**
	 * methode de suppression d'un compte d'appres l'id, retourne un boolean
	 * 
	 */
	public boolean suppression(int id) {
		return conseillerCompteCRUDDao.suppression(id);
	}

	/**
	 * methode prenant en parametre l'id d'un conseiller et retourne la liste
	 * des id de tous les comptes courants de ses clients
	 * 
	 * @param idConseiller
	 * @return
	 */
	public ArrayList<Integer> getIdCompteCourantAvecIdConseiller(int idConseiller) {
		return (ArrayList<Integer>) conseillerClientCRUDService.lire(idConseiller).stream()
				.map(c -> c.getIdCompteCourant()).filter(c -> c != 0).collect(Collectors.toList());
	}

	/**
	 * methode prenant en parametre l'id d'un conseiller et retourne la liste
	 * des id de tous les comptes epargne de ses clients
	 * 
	 * @param idConseiller
	 * @return
	 */
	public ArrayList<Integer> getIdCompteEpargneAvecIdConseiller(int idConseiller) {
		return (ArrayList<Integer>) conseillerClientCRUDService.lire(idConseiller).stream()
				.map(c -> c.getIdCompteEpargne()).filter(c -> c != 0).collect(Collectors.toList());
	}

	/**
	 * methode prenant en parametre l'id d'un conseiller et retourne la liste
	 * des id de tous les comptes de ses clients
	 * 
	 * @param idConseiller
	 * @return
	 */
	public ArrayList<Integer> getIdToutCompteAvecIdConseiller(int idConseiller) {
		ArrayList compteParConseiller = getIdCompteCourantAvecIdConseiller(idConseiller);
		compteParConseiller.addAll(getIdCompteEpargneAvecIdConseiller(idConseiller));
		return compteParConseiller;
	}

}
