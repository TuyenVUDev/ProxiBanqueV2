package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.GerantCrudDao;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;

public class GerantCRUDService implements CrudInterface {

	GerantCrudDao gerantCrudDao = new GerantCrudDao();
	
	public boolean ajout(Conseiller conseiller) {
		gerantCrudDao.ajouter(conseiller);
		return true;
	}


	public Conseiller lireConseillerById(int id) {
		return gerantCrudDao.lireConseillerById(id);
	}
	
	
	public boolean purge() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean supprimer(int id) {
		return gerantCrudDao.suppression(id);
	}

}
