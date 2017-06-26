package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.proxibanque.dao.ConseillerClientCRUDDao;
import fr.gtm.proxibanque.dao.ConseillerCompteCRUDDao;

public class ConseillerCompteCRUDService implements CRUDInterface {


ConseillerCompteCRUDDao conseillerCompteCRUDDao =new ConseillerCompteCRUDDao();	
	
	public boolean ajout(Compte compte) {
		conseillerCompteCRUDDao.ajout(compte);
		return true;
	}

	public ArrayList<Compte> lire(){
		return conseillerCompteCRUDDao.lireListe();
		
	};
	public Compte lireById(int id) {
		return conseillerCompteCRUDDao.lireById(id);
	}
	
	
	public boolean purge() {
		return conseillerCompteCRUDDao.purgeTable();
	}

	public boolean suppression(int id) {
		return conseillerCompteCRUDDao.suppression(id);
	}

}
