package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;

public interface CRUDInterface {
	public abstract boolean purge();
	public abstract boolean supprimer(int id);
	
}
	
