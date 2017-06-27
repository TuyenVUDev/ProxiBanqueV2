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
import fr.gtm.proxibanque.domain.Conseiller;

public class GerantCrudDao extends AccesDao {

	/**
	 * ajout d'un conseiller en base
	 * 
	 * @param conseiller
	 * @return
	 */
	public boolean ajouter(Conseiller conseiller) {
		String nom = conseiller.getNom();
		String prenom = conseiller.getPrenom();
		String password = conseiller.getPswd();
		String login = conseiller.getLogin();

		String insertString = "INSERT INTO `conseillers` (  `nom`, `prenom`, `login`, `password`) VALUES(?,?,?,?)";

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst = cn.prepareStatement(insertString);

			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, login);
			pst.setString(4, password);

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
	 * suppression d'un conseiller en base a partir de son id
	 * 
	 * @param id
	 * @return
	 */
	public boolean supprimerById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Client client = em.find(Client.class, id);
		em.remove(client);
		tx.commit();
		em.clear();
		emf.close();
		return true;
	}

	/**
	 * lecture d'un conseiller en base a partir de son id, retourne un opobjet
	 * Conseiller
	 * 
	 * @param id
	 * @return
	 */
	public Conseiller lireConseillerById(int id) {
		String nom = "inconnu";
		String prenom = "inconnu";
		String login = "inconnu";
		String paswd = "inconnu";
		Conseiller conseiller = null;

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
			login = rs.getString(4);
			paswd = rs.getString(5);
			conseiller = new Conseiller(nom, prenom, login, paswd);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// etape 5 liberer ressources de la memoire
				cn.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conseiller;

	}

	/**
	 * retourne la liste de tous les conseillers
	 * @return
	 */
	public ArrayList<Conseiller> lireListe() {
		ArrayList<Conseiller> conseillers = new ArrayList<Conseiller>();
		String nom;
		String prenom;
		String login;
		String paswd;
		int id = 0;
		Conseiller conseiller = null;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM conseillers ";
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			// etape 5 (parcours resultSet)
			while (rs.next()) {
				id = rs.getInt(1);
				nom = rs.getString(2);
				prenom = rs.getString(3);
				login = rs.getString(4);
				paswd = rs.getString(5);

				conseiller = new Conseiller(id, nom, prenom, login, paswd);
				conseillers.add(conseiller);
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
		return conseillers;
	}
/**
 * supprime de la base un conseiller d'apres son id
 * @param id
 * @return
 */
	public boolean suppression(int id) {
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "DELETE FROM `conseillers` WHERE id = " + id;
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
 * vide la table conseillers
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
			String sql = "TRUNCATE TABLE conseillers";
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
 * modification des infos d'un conseiller d'apres son id 
 * @param id
 * @param conseiller : objet avec les nouvelles proprietes
 * @return
 */
	public boolean modifierConseiller(int id, Conseiller conseiller) {
		String nom = conseiller.getNom();
		String prenom = conseiller.getPrenom();
		String login = conseiller.getLogin();
		String paswd = conseiller.getPswd();

		String insertString = "UPDATE `conseillers` SET nom=?,prenom =?,login=?,password=? WHERE id=" + id;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst = cn.prepareStatement(insertString);
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, login);
			pst.setString(4, paswd);

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
