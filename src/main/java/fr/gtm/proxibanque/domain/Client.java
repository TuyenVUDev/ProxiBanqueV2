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
	private int idCompteEpargne;
	private int idCompteCourant;
	private int idConseiller;

	// constructeur


	public Client(int id,String nom, String prenom, String adresse,
			String email,int idCompteCourant, int idCompteEpargne, int idConseiller) {
		this.id=id;
		this.adresse = adresse;
		this.email = email;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.idCompteCourant= idCompteCourant;
		this.idCompteEpargne=idCompteEpargne;
		this.idConseiller = idConseiller;
	}
	public Client(int id,String nom, String prenom, String adresse,
			String email, int idConseiller) {
		this.id=id;
		this.adresse = adresse;
		this.email = email;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.idConseiller = idConseiller;
	}
	
	public Client(String nom, String prenom, String adresse,
			String email, int idConseiller) {
		this.adresse = adresse;
		this.email = email;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.idCompteCourant= 0;
		this.idCompteEpargne=0;
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

	

	

	

	public int getIdCompteEpargne() {
		return idCompteEpargne;
	}

	public void setIdCompteEpargne(int idCompteEpargne) {
		this.idCompteEpargne = idCompteEpargne;
	}

	public int getIdCompteCourant() {
		return idCompteCourant;
	}

	public void setIdCompteCourant(int idCompteCourant) {
		this.idCompteCourant = idCompteCourant;
	}

	public int getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + this.getNom()+ ", prenom=" +this.getPrenom()+", adresse=" + adresse + ", email=" + email + ", idCompteCourant=" + idCompteCourant
				+ ", idCompteEpargne=" + idCompteEpargne + ", idConseiller=" + idConseiller + "]";
	}

	

	
	
	




}
