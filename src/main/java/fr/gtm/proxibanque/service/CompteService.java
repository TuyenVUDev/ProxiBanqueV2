package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.CompteDao;
import fr.gtm.proxibanque.domain.Compte;

public class CompteService implements CrudInterface{

	CompteDao compteDao = new CompteDao();
	
	public boolean ajouter(Compte compte){
		return compteDao.ajouterEnBase(compte);
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
