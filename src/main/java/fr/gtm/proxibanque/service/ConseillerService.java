package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.ConseillerClientCRUDDao;
import fr.gtm.proxibanque.dao.ConseillerDao;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;

public class ConseillerService {

	ConseillerDao conseillerDao = new ConseillerDao();
	ConseillerCompteCRUDService conseillerCompteCRUDService = new ConseillerCompteCRUDService();
	
	public boolean associationCompte(int idCompte, int idClient) {
		if (conseillerCompteCRUDService.lireCompteById(idCompte).getTypeDeCompte().equals("courant")==true) {
		return conseillerDao.associerCompteCourant(idCompte, idClient);
		} 
		else {
		return conseillerDao.associerCompteEpargne(idCompte, idClient);
		}

	}

}
