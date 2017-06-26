package fr.gtm.proxibanque.service;

import java.util.stream.Collectors;

public class AuthentificationService {

	GerantCRUDService gerantCRUDService = new GerantCRUDService();

	public boolean testLogin(String login) {
		return gerantCRUDService.lire().stream().map(l -> l.getLogin()).anyMatch(l -> l.equals(login));
	}

	public boolean testPaswd(String paswd) {
		return gerantCRUDService.lire().stream().map(l -> l.getPswd()).anyMatch(l -> l.equals(paswd));
	}

	public boolean authentification(String login, String paswd) {
		if (testLogin(login) == true && testPaswd(paswd) == true) {
			return gerantCRUDService.lire().stream().filter(c -> c.getLogin().equals(login)).map(c -> c.getPswd())
					.anyMatch(p -> p.equals(paswd));
		} else {
			return false;
		}

	}
}
