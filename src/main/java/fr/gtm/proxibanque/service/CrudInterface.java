package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;

public interface CrudInterface {
	public abstract boolean purge();
	public abstract boolean supprimer(int id);
	
}
	
