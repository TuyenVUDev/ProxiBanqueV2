package fr.gtm.proxibanque.domain;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	
	
	
	
	public Gerant(String nom, String prenom, String pswd, String login) {
		super(nom, prenom, pswd, login);
		this.setPswd(pswd);
		this.setLogin(login);
		this.setNom(nom);
		this.setPrenom(prenom);
		
	}
	@Override
	public String toString() {
		return "Gerant [id=" + id + ", nom=" + this.getNom() + ", prenom=" + getPrenom() +  ", pswd=" + getPswd() + ", login=" + getLogin()+ "]";
	}
	
	

}
