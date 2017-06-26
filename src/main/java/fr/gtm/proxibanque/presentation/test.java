package fr.gtm.proxibanque.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.domain.Client;

public class test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		Client client = new Client("vu", "tuyen", "21 quai V. Augagneur", "tuyentown@gmail.com");
		em.persist(client);
		
		tx.commit();
		em.clear();
		emf.close();
	}

}
