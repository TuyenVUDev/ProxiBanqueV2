package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.proxibanque.dao.ConseillerClientCRUDDao;

public class ConseillerClientCRUDService implements CRUDInterface {


ConseillerClientCRUDDao conseillerClientCrudDao = new ConseillerClientCRUDDao();
	
	
	public boolean ajout(Client client) {
		conseillerClientCrudDao.ajout(client);
		return true;
	}


	public Client lireClientById(int id) {
		return conseillerClientCrudDao.lireClientById(id);
	}
	public ArrayList<Client> lire() {
		return conseillerClientCrudDao.lireListe();
	}

	public boolean modifier(int id , Client client){
		return conseillerClientCrudDao.modifierClient(id, client);
	}
	
	public boolean purge() {
		return conseillerClientCrudDao.purgeTable();
	}

	public boolean suppression(int id) {
		return conseillerClientCrudDao.supprimerById(id);
	}

}
