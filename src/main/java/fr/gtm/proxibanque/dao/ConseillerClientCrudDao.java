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

public class ConseillerClientCrudDao extends AccesDao{


	public boolean ajout(Client client) {
		String nom = client.getNom();
		String prenom = client.getPrenom();
		String adresse = client.getAdresse();
		String email = client.getEmail();
				int idConseiller=client.getIdConseiller();
		
		String insertString = "INSERT INTO `clients` ( `nom`, `prenom`, `adresse`, `email`, `idConseiller`) VALUES(?,?,?,?,?)";
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst=cn.prepareStatement(insertString);
			pst.setString(1,nom);
			pst.setString(2,prenom);
			pst.setString(3,adresse);
			pst.setString(4,email);
			pst.setInt(5, idConseiller);
			
			
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
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return true;
	}
	
	public boolean supprimerById(int id) {

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "DELETE FROM `clients` WHERE id = " + id ;
			// etape 4 = execution requete
			st.executeUpdate(sql);
			// etape 5 (parcours resultSet)

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
		return true;
	}
	
	public Client getClientById(int id){
		
		String nom = "inconnu";
		String prenom = "inconnu";
		String adresse = "inconnu";
		String email = "inconnu";
		int idCC = 0;
		int idCE = 0;
		Compte compteCourant=null;
		Compte compteEpargne=null;
		int idConseiller=0;


		Client client = null;
		ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM conseillers WHERE id=" + id;
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			rs.next();
			// etape 5 (parcours resultSet)
			nom = rs.getString(2);
			prenom = rs.getString(3);
			adresse = rs.getString(4);
			email = rs.getString(5);
			idCC = rs.getInt(6);
			idCE = rs.getInt(7);
			compteCourant=conseillerCompteCRUDDao.lireById(idCC);
			compteEpargne=conseillerCompteCRUDDao.lireById(idCE);
			idConseiller=rs.getInt(8);
			client = new Client(nom,prenom,adresse,email,compteCourant,compteEpargne,idConseiller);
			
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

		return client;
	}
	
	public ArrayList<Client> lireListe() {
		ArrayList<Client> clients = new ArrayList<Client>();
		String nom = "inconnu";
		String prenom = "inconnu";
		String adresse = "inconnu";
		String email = "inconnu";
		int id = 0;
		int idConseiller=0;
		int idCompteCourant=0;
		int idCompteEpargne=0;
		ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();
		
		Client client= null;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM clients ";
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			// etape 5 (parcours resultSet)
			while (rs.next()) {
				nom = rs.getString(2);
				prenom = rs.getString(3);
				id = rs.getInt(1);
				adresse = rs.getString(4);
				email=rs.getString(5);
				idCompteCourant=rs.getInt(6);
				idCompteEpargne=rs.getInt(7);
				idConseiller=rs.getInt(8);
				client = new Client(nom, prenom, adresse, email, conseillerCompteCRUDDao.lireById(idCompteEpargne), conseillerCompteCRUDDao.lireById(idCompteEpargne), idConseiller);
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
	
	
	
	
	
}
