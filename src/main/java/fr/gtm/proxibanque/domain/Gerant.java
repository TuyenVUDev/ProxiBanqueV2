package fr.gtm.proxibanque.domain;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * herite de conseiller
 * @author Stagiaire
 *
 */
public class Gerant extends Conseiller{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	public Gerant(int id,String nom, String prenom, String pswd, String login) {
		super(id, nom, prenom, pswd, login);
		
	}
	
	public Gerant(String nom, String prenom, String login, String pswd) {
		super(nom, prenom, login, pswd);
	}
	@Override
	public String toString() {
		return "Gerant [id=" + id + ", nom=" + this.getNom() + ", prenom=" + getPrenom() +  ", pswd=" + getPswd() + ", login=" + getLogin()+ "]";
	}
	
	

}
