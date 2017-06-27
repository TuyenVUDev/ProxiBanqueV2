package fr.gtm.proxibanque.domain;


/**
 * classe abstraite generalisant les proprietes nom et prenom
 * @author Stagiaire
 *
 */
public abstract class Personne {

	private String nom;
	private String prenom;
	private int id;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
}
