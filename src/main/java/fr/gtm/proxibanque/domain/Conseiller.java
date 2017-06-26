package fr.gtm.proxibanque.domain;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Conseiller extends Personne{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idConseiller;
	private String password,login;
	private ArrayList<Client> listeClients;
	
	
	
	public int getId() {
		return idConseiller;
	}
	public void setId(int id) {
		this.idConseiller = id;
	}
	public String getPswd() {
		return password;
	}
	public void setPswd(String pswd) {
		this.password = pswd;
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
	
	
	
	
	public Conseiller(int id, String nom, String prenom, String login, String pswd) {
		super();
		this.idConseiller=id;
		this.password = pswd;
		this.login = login;
		this.setNom(nom);
		this.setPrenom(prenom);
		
	}
	public Conseiller(String nom, String prenom, String login, String pswd) {
		super();
		this.password = pswd;
		this.login = login;
		this.setNom(nom);
		this.setPrenom(prenom);
		
	}
	
	
	@Override
	public String toString() {
		return "Conseiller [id=" + idConseiller + ", nom=" + this.getNom() + ", prenom=" + getPrenom() +  ", pswd=" + password + ", login=" + login + "]";
	}
	
	

}
