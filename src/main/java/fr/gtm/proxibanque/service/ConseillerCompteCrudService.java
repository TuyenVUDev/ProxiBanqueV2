package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.proxibanque.dao.ConseillerClientCrudDao;
import fr.gtm.proxibanque.dao.ConseillerCompteCRUDDao;

public class ConseillerCompteCrudService implements CrudInterface {


ConseillerCompteCRUDDao conseillerCompteCRUDDao =new ConseillerCompteCRUDDao();	
	
	public boolean ajout(Compte compte) {
		conseillerCompteCRUDDao.ajout(compte);
		return true;
	}


	public Compte lireCompteById(int id) {
		return conseillerCompteCRUDDao.lireById(id);
	}
	
	
	public boolean purge() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean supprimer(int id) {
		return conseillerCompteCRUDDao.suppression(id);
	}

}
