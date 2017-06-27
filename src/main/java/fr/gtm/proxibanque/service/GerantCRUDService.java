package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.dao.GerantCrudDao;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;

public class GerantCRUDService implements CRUDInterface {

	GerantCrudDao gerantCrudDao = new GerantCrudDao();

	/**
	 * methode d'ajout d'un conseiller, retourne un boolean
	 * 
	 * @param conseiller
	 * @return
	 */
	public boolean ajout(Conseiller conseiller) {
		gerantCrudDao.ajouter(conseiller);
		return true;
	}

	/**
	 * methode de modification des infos d'un conseiller a partir de son id
	 * 
	 * @param id
	 * @param conseiller
	 * @return
	 */
	public boolean modification(int id, Conseiller conseiller) {
		return gerantCrudDao.modifierConseiller(id, conseiller);
	}

	/**
	 * retourne un conseiller d'apres une id
	 * 
	 * @param id
	 * @return
	 */
	public Conseiller lireConseillerById(int id) {
		return gerantCrudDao.lireConseillerById(id);
	}

	/**
	 * retourne la liste des conseillers
	 * 
	 * @return
	 */
	public ArrayList<Conseiller> lire() {
		return gerantCrudDao.lireListe();
	}

	/**
	 * vide la table des conseillers et retourne un boolean
	 */
	public boolean purge() {
		return gerantCrudDao.purgeTable();
	}

	/**
	 * suppression d'un conseiller d'apres l'id
	 */
	public boolean suppression(int id) {
		return gerantCrudDao.suppression(id);
	}

}
