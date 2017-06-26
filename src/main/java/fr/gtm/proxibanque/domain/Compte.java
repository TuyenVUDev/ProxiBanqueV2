package fr.gtm.proxibanque.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Compte {


	private int id;
	private String typeDeCompte;
	private float solde;
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
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public Compte(String typeDeCompte, float solde) {
		super();
		this.typeDeCompte = typeDeCompte;
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Compte [typeDeCompte=" + typeDeCompte + ", solde=" + solde + "]";
	}
	
	
}
