package fr.gtm.proxibanque.domain;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Conseiller extends Personne{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String pswd,login;
	private ArrayList<Client> listeClients;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public ArrayList<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	
	
	
	public Conseiller(String nom, String prenom, String pswd, String login) {
		super();
		this.pswd = pswd;
		this.login = login;
		this.setNom(nom);
		this.setPrenom(prenom);
		
	}
	
	
	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + this.getNom() + ", prenom=" + getPrenom() +  ", pswd=" + pswd + ", login=" + login + "]";
	}
	
	

}
