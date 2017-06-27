package fr.gtm.proxibanque.service;

public interface CRUDInterface {
	/**
	 * methode abstraite pour vider les tables
	 * 
	 * @return
	 */
	public abstract boolean purge();

	/**
	 * methode abstraite de suppresion d'un element d'apres son id
	 * 
	 * @param id
	 * @return
	 */
	public abstract boolean suppression(int id);

}
