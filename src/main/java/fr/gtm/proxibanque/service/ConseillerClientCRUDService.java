package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.proxibanque.dao.ConseillerClientCRUDDao;

public class ConseillerClientCRUDService implements CRUDInterface {

	ConseillerClientCRUDDao conseillerClientCrudDao = new ConseillerClientCRUDDao();

	/**
	 * ajoute un objet client en retournant un booleen
	 * 
	 * @param client
	 * @return
	 */
	public boolean ajout(Client client) {
		conseillerClientCrudDao.ajout(client);
		return true;
	}

	/**
	 * methode retournant un objet de classe Client avec un id en parametre
	 * 
	 * @param id
	 * @return
	 */
	public Client lireById(int id) {
		return conseillerClientCrudDao.lireClientById(id);
	}

	/**
	 * methode retournant une liste de clients d'un conseiller avec l'id en
	 * parametre
	 * 
	 * @param idConseiller
	 * @return
	 */
	public ArrayList<Client> lire(int idConseiller) {
		return conseillerClientCrudDao.lireListe(idConseiller);
	}

	/**
	 * methode de modification des donnes d'un client a partir de l'idClient et
	 * d'un ojjet Client
	 * 
	 * @param id
	 * @param client
	 * @return
	 */
	public boolean modification(int id, Client client) {
		return conseillerClientCrudDao.modifierClient(id, client);
	}

	/**
	 * methode pour vider la table client et reinitialiser l'auto increment de
	 * l'id
	 */
	public boolean purge() {
		return conseillerClientCrudDao.purgeTable();
	}

	/**
	 * methode de suppression d'un client a partir de son id
	 * 
	 * @param id
	 */
	public boolean suppression(int id) {
		return conseillerClientCrudDao.supprimerById(id);
	}

}
