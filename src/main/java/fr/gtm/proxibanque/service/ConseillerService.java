package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.ConseillerCompteCRUDDao;
import fr.gtm.proxibanque.dao.ConseillerDao;
import fr.gtm.proxibanque.domain.Compte;

public class ConseillerService {

	ConseillerDao conseillerDao = new ConseillerDao();
	ConseillerCompteCRUDService conseillerCompteCRUDService = new ConseillerCompteCRUDService();
	ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();

	/**
	 * methode associant un idCompte a un idClient, retourne un boolean
	 * 
	 * @param idCompte
	 * @param idClient
	 * @return
	 */
	public boolean associationCompte(int idCompte, int idClient) {
		if (conseillerCompteCRUDService.lireById(idCompte).getTypeDeCompte().equals("courant") == true) {
			return conseillerDao.associerCompteCourant(idCompte, idClient);
		} else {
			return conseillerDao.associerCompteEpargne(idCompte, idClient);
		}

	}

	/**
	 * methode effectuant un virement d'un compte debiteur vers un compte
	 * credite
	 * 
	 * @param idCompteDeb
	 *            : id du compte debite
	 * @param idCompteCred
	 *            : id du compte credite
	 * @param montant
	 *            : valeur (double) du virement
	 * @return
	 */
	public boolean effectuerVirement(int idCompteDeb, int idCompteCred, double montant) {

		double nouveauSoldeCDeb = conseillerCompteCRUDService.lireById(idCompteDeb).getSolde() - montant;
		double nouveauSoldeCCred = conseillerCompteCRUDService.lireById(idCompteCred).getSolde() + montant;
		conseillerCompteCRUDDao.modifierSoldeCompte(idCompteDeb, nouveauSoldeCDeb);
		conseillerCompteCRUDDao.modifierSoldeCompte(idCompteCred, nouveauSoldeCCred);
		return true;
	}

	/**
	 * methode permettant de recuperer le solde d'un compte en fonction de son
	 * Id
	 * 
	 * @param idCompte
	 *            : id du compte
	 *
	 *
	 * @return double : solde du compte
	 */

	public double getSoldeCompteByID(int idCompte) {
		Compte compte = conseillerCompteCRUDDao.lireById(idCompte);
		double solde = compte.getSolde();
		return solde;
	}
}
