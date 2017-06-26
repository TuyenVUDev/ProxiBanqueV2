package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.proxibanque.dao.ConseillerClientCrudDao;

public class ConseillerClientCrudService implements CrudInterface {


ConseillerClientCrudDao conseillerClientCrudDao = new ConseillerClientCrudDao();
	
	
	public boolean ajout(Client client) {
		conseillerClientCrudDao.ajout(client);
		return true;
	}


	public Client lireClientById(int id) {
		return conseillerClientCrudDao.getClientById(id);
	}
	
	
	public boolean purge() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
