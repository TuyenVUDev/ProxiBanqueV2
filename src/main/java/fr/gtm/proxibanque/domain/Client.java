package fr.gtm.proxibanque.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class Client extends Personne{
	// proprietes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String adresse, email;
	private Compte compteEpargne;
	private Compte compteCourant;
	private int idConseiller;

	// constructeur


	public Client(String nom, String prenom, String adresse,
			String email,Compte compteCourant, Compte compteEpargne, int idConseiller) {
		this.adresse = adresse;
		this.email = email;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.compteCourant= compteCourant;
		this.compteEpargne=compteEpargne;
		this.idConseiller = idConseiller;
	}
	
	public Client(String nom, String prenom, String adresse,
			String email, int idConseiller) {
		this.adresse = adresse;
		this.email = email;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.compteCourant= null;
		this.compteEpargne=null;
		this.idConseiller = idConseiller;
	}
	

	public Client() {
		super();
	}


	// getters setters


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Compte getCompteEpargne() {
		return compteEpargne;
	}


	public void setCompteEpargne(Compte compteEpargne) {
		this.compteEpargne = compteEpargne;
	}


	public Compte getCompteCourant() {
		return compteCourant;
	}


	public void setCompteCourant(Compte compteCourant) {
		this.compteCourant = compteCourant;
	}

	

	public int getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + this.getNom()+ ", prenom=" +this.getPrenom()+", adresse=" + adresse + ", email=" + email + ", compteEpargne=" + compteEpargne
				+ ", compteCourant=" + compteCourant + ", idConseiller=" + idConseiller + "]";
	}

	

	
	
	




}
