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

public class ConseillerClientCRUDDao extends AccesDao {

	
	/**
	 * ajout en base d'un client, retour d'un boolean
	 * @param client
	 * @return
	 */
	public boolean ajout(Client client) {
		String nom = client.getNom();
		String prenom = client.getPrenom();
		String adresse = client.getAdresse();
		String email = client.getEmail();
		int idCompteCourant = 0;
		int idCompteEpargne = 0;
		int idConseiller = client.getIdConseiller();

		String insertString = "INSERT INTO `clients` ( `nom`, `prenom`, `adresse`, `email`,`idCompteCourant`,`idCompteEpargne`, `idConseiller`) VALUES(?,?,?,?,?,?,?)";

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst = cn.prepareStatement(insertString);
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, adresse);
			pst.setString(4, email);
			pst.setInt(5, idCompteCourant);
			pst.setInt(6, idCompteEpargne);
			pst.setInt(7, idConseiller);

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
/**
 * suppression en base d'un client
 * @param id
 * @return
 */
	public boolean supprimerById(int id) {

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "DELETE FROM `clients` WHERE id = " + id;
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
/**
 * lecture d'un client en base, retour d'un objet Client
 * @param id
 * @return
 */
	public Client lireClientById(int id) {

		String nom = "inconnu";
		String prenom = "inconnu";
		String adresse = "inconnu";
		String email = "inconnu";
		int idCC;
		int idCE;
		Compte compteCourant = null;
		Compte compteEpargne = null;
		int idConseiller = 0;

		Client client = null;
		ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM clients WHERE id=" + id;
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
			idConseiller = rs.getInt(8);
			client = new Client(id, nom, prenom, adresse, email, idCC, idCE, idConseiller);

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

	/**
	 * Liste des clients lies a un conseiller
	 * @param idConseillerCourant : id du conseiller
	 * @return
	 */
	public ArrayList<Client> lireListe(int idConseillerCourant) {
		ArrayList<Client> clients = new ArrayList<Client>();
		String nom = "inconnu";
		String prenom = "inconnu";
		String adresse = "inconnu";
		String email = "inconnu";
		int id = 0;
		int idConseiller;
		int idCompteCourant;
		int idCompteEpargne;

		Client client = null;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM clients WHERE idConseiller="+idConseillerCourant;
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			// etape 5 (parcours resultSet)
			while (rs.next()) {
				id = rs.getInt(1);
				nom = rs.getString(2);
				prenom = rs.getString(3);
				id = rs.getInt(1);
				adresse = rs.getString(4);
				email = rs.getString(5);
				idCompteCourant = rs.getInt(6);
				idCompteEpargne = rs.getInt(7);
				idConseiller = rs.getInt(8);
				client = new Client(id, nom, prenom, adresse, email, idCompteCourant, idCompteEpargne, idConseiller);
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
/**
 * vide la table de clients, retourne un boolean
 * @return
 */
	public boolean purgeTable() {
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "TRUNCATE TABLE clients";
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
/**
 * modification des donnees client en base
 * @param id
 * @param client
 * @return
 */
	public boolean modifierClient(int id, Client client) {
		String nom = client.getNom();
		String prenom = client.getPrenom();
		String adresse = client.getAdresse();
		String email = client.getEmail();
		int idConseiller = client.getIdConseiller();
		int idCompteCourant = client.getIdCompteCourant();
		int idCompteEpargne = client.getIdCompteEpargne();

		String insertString = "UPDATE `clients` SET nom=?,prenom =?,adresse=?,email=?,idConseiller=? WHERE id=" + id;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst = cn.prepareStatement(insertString);
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, adresse);
			pst.setString(4, email);
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
}
