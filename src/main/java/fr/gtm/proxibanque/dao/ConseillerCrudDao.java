package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;

public class ConseillerCrudDao extends AccesDao{


	public boolean ajouterEnBase(Conseiller conseiller) {
		String nom = conseiller.getNom();
		String prenom = conseiller.getPrenom();
		String password = conseiller.getPswd();
		String login = conseiller.getLogin();
		
		String insertString = "INSERT INTO `conseillers` ( `nom`, `prenom`, `login`, `password`) VALUES(?,?,?,?)";
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, login, passwd);
			// etape 3 : creation d'un statement
			pst=cn.prepareStatement(insertString);
			pst.setString(2,nom);
			pst.setString(3,prenom);
			pst.setString(4,login);
			pst.setString(5,password);
			
			// etape 4 = execution requete
			
			pst.executeUpdate();
			// etape 5 (parcours resultSet)
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// etape 6 liberer ressources de la memoire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
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
	
	public ArrayList<Client> lireListe() {
		ArrayList<Client> clients = new ArrayList<Client>();
		String nom = "inconnu";
		String prenom = "inconnu";
		String adresse = "inconnu";
		String email = "inconnu";
		int id = 0;
		Client client= null;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, login, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM materiel ";
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			// etape 5 (parcours resultSet)
			while (rs.next()) {
				nom = rs.getString(2);
				prenom = rs.getString(3);
				id = rs.getInt(1);
				client = new Client();
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// etape 5 liberer ressources de la memoire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clients;
	}
	
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
