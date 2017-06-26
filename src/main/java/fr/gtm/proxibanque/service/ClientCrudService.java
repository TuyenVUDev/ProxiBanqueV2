package fr.gtm.proxibanque.service;
import fr.gtm.proxibanque.domain.Client;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


import fr.gtm.proxibanque.dao.ClientCrudDao;

public class ClientCrudService implements CrudInterface{

	ClientCrudDao clientCrudDao = new ClientCrudDao();

	public boolean ajout(Client client) {
		return clientCrudDao.ajouterEnBase(client);
	}

	
	
	public boolean modifierClient(int id, Client client) {
		return clientCrudDao.modifierClient(id, client);
	}
	
	public boolean purge() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean supprimer(int id) {
		return clientCrudDao.supprimerById(id);
	}

	

	}


