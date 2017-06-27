package fr.gtm.proxibanque.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe compte avec trois attributs id, typeDeComte,Solde
 * @author Stagiaire
 *
 */
public class Compte {


	private int id;
	private String typeDeCompte;
	private double solde;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeDeCompte() {
		return typeDeCompte;
	}
	public void setTypeDeCompte(String typeDeCompte) {
		this.typeDeCompte = typeDeCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Compte(String typeDeCompte, double solde) {
		super();
		this.typeDeCompte = typeDeCompte;
		this.solde = solde;
	}
	public Compte(int id, String typeDeCompte, double solde) {
		super();
		this.id=id;
		this.typeDeCompte = typeDeCompte;
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", typeDeCompte=" + typeDeCompte + ", solde=" + solde + "]";
	}

	
	
}
