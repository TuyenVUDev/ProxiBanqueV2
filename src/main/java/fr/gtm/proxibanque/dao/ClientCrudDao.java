package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.domain.Client;

public class ClientCrudDao {

	public boolean ajouterEnBase(Client client) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(client);
		tx.commit();
		em.clear();
		emf.close();
		return true;
	}
	
	public boolean supprimerById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Client client = em.find(Client.class, id);
		em.remove(client);
		tx.commit();
		em.clear();
		emf.close();
		return true;
	}
	
	public Client getClientById(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Client client = em.find(Client.class, id);
		em.remove(client);
		tx.commit();
		em.clear();
		emf.close();
		return client;
	}
	
//	public ArrayList<Client> getAllClient(){
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx=em.getTransaction();
//		tx.begin();
//		em.ge
//		Client client = em.find(Client.class, id);
//		em.remove(client);
//		tx.commit();
//		em.clear();
//		emf.close();
//		return client;
//	}
	
	public boolean modifierClient(int id, Client clientNew){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Client client = em.find(Client.class, id);
		client.setAdresse(clientNew.getAdresse());
		client.setEmail(clientNew.getEmail());
		client.setNom(clientNew.getNom());
		client.setPrenom(clientNew.getNom());
		em.refresh(client);
		tx.commit();
		em.clear();
		emf.close();
		return true;
		
	}
	
	
}
