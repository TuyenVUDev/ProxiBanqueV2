package fr.gtm.proxibanque.service;

import java.util.stream.Collectors;

public class AuthentificationService {

	GerantCRUDService gerantCRUDService = new GerantCRUDService();

	
	/**
	 * Methode pour verifier que la valeur login existe en table 
	 * @param login
	 * @return
	 */
	public boolean testLogin(String login) {
		return gerantCRUDService.lire().stream().map(l -> l.getLogin()).anyMatch(l -> l.equals(login));
	}

	/**
	 * Methode pour verifier que lla valeur password existe en table 
	 * @param paswd
	 * @return
	 */

	public boolean testPaswd(String paswd) {
		return gerantCRUDService.lire().stream().map(l -> l.getPswd()).anyMatch(l -> l.equals(paswd));
	}

/**
 * Methode pour verifier que la valeur password existe en table 
 * 
 * @param login
 * @param paswd
 * @return
 */
	public boolean authentification(String login, String paswd) {
		if (testLogin(login) == true && testPaswd(paswd) == true) {
			return gerantCRUDService.lire().stream().filter(c -> c.getLogin().equals(login)).map(c -> c.getPswd())
					.anyMatch(p -> p.equals(paswd));
		} else {
			return false;
		}

	}
}
