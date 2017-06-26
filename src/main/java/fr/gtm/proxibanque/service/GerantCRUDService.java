package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.dao.GerantCrudDao;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;

public class GerantCRUDService implements CRUDInterface {

	GerantCrudDao gerantCrudDao = new GerantCrudDao();
	
	public boolean ajout(Conseiller conseiller) {
		gerantCrudDao.ajouter(conseiller);
		return true;
	}


	public Conseiller lireConseillerById(int id) {
		return gerantCrudDao.lireConseillerById(id);
	}
	public ArrayList<Conseiller> lire(){
		return gerantCrudDao.lireListe();
	}
 	
	public boolean purge() {
		return gerantCrudDao.purgeTable();
	}

	public boolean supprimer(int id) {
		return gerantCrudDao.suppression(id);
	}

}
