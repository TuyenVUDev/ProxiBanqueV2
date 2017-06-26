package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.ConseillerCompteCRUDDao;
import fr.gtm.proxibanque.dao.ConseillerDao;


public class ConseillerService {

	ConseillerDao conseillerDao = new ConseillerDao();
	ConseillerCompteCRUDService conseillerCompteCRUDService = new ConseillerCompteCRUDService();
	ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();

	public boolean associationCompte(int idCompte, int idClient) {
		if (conseillerCompteCRUDService.lireById(idCompte).getTypeDeCompte().equals("courant") == true) {
			return conseillerDao.associerCompteCourant(idCompte, idClient);
		} else {
			return conseillerDao.associerCompteEpargne(idCompte, idClient);
		}

	}

	public boolean effectuerVirement(int idCompteDeb, int idCompteCred, double montant) {
		
		double nouveauSoldeCDeb=conseillerCompteCRUDService.lireById(idCompteDeb).getSolde()-montant;
		double nouveauSoldeCCred=conseillerCompteCRUDService.lireById(idCompteCred).getSolde()+montant;
		conseillerCompteCRUDDao.modifierSoldeCompte(idCompteDeb, nouveauSoldeCDeb);
		conseillerCompteCRUDDao.modifierSoldeCompte(idCompteCred, nouveauSoldeCCred);
		return true;
	}

}
