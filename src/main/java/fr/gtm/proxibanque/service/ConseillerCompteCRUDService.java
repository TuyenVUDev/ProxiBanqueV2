package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.gtm.proxibanque.dao.ConseillerClientCRUDDao;
import fr.gtm.proxibanque.dao.ConseillerCompteCRUDDao;

public class ConseillerCompteCRUDService implements CRUDInterface {

	ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();
	ConseillerClientCRUDService conseillerClientCRUDService = new ConseillerClientCRUDService();

	public boolean ajout(Compte compte) {
		conseillerCompteCRUDDao.ajout(compte);
		return true;
	}

	public ArrayList<Compte> lire() {
		return conseillerCompteCRUDDao.lireListe();

	};

	public Compte lireById(int id) {
		return conseillerCompteCRUDDao.lireById(id);
	}

	public boolean purge() {
		return conseillerCompteCRUDDao.purgeTable();
	}

	public boolean suppression(int id) {
		return conseillerCompteCRUDDao.suppression(id);
	}

	public ArrayList<Integer> getIdCompteCourantAvecIdConseiller(int idConseiller) {
		return (ArrayList<Integer>) conseillerClientCRUDService.lire(idConseiller).stream().map(c -> c.getIdCompteCourant())
				.filter(c -> c != 0).collect(Collectors.toList());
	}

	public ArrayList<Integer> getIdCompteEpargneAvecIdConseiller(int idConseiller) {
		return (ArrayList<Integer>) conseillerClientCRUDService.lire(idConseiller).stream().map(c -> c.getIdCompteEpargne())
				.filter(c -> c != 0).collect(Collectors.toList());
	}

	public ArrayList<Integer> getIdToutCompteAvecIdConseiller(int idConseiller) {
		ArrayList compteParConseiller = getIdCompteCourantAvecIdConseiller(idConseiller);
		compteParConseiller.addAll(getIdCompteEpargneAvecIdConseiller(idConseiller));
		return compteParConseiller;
	}

}
