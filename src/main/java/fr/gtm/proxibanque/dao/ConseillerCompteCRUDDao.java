package fr.gtm.proxibanque.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.domain.Conseiller;

public class ConseillerCompteCRUDDao extends AccesDao{
/**
 * ajout dun compte en base
 * @param compte
 * @return
 */
	public boolean ajout(Compte compte) {

		String typeDeCompte=compte.getTypeDeCompte();
		double solde=compte.getSolde();
		
		
		String insertString = "INSERT INTO `comptes` ( `typeDeCompte`, `solde`) VALUES(?,?)";
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst=cn.prepareStatement(insertString);
			pst.setString(1,typeDeCompte);
			pst.setDouble(2,solde);
			
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
	 * lecture d'un compte en base a partir de l'id, retourne un compte
	 * @param id
	 * @return
	 */
	public Compte lireById(int id){
		String typeDeCompte = "inconnu";
		double solde = 0;

		Compte compte = null;

		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM comptes WHERE id=" + id;
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			rs.next();
			// etape 5 (parcours resultSet)
			typeDeCompte = rs.getString(2);
			solde = rs.getDouble(3);
			compte = new Compte(typeDeCompte, solde);
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
		return compte;
	}
	/**
	 * retourne la liste de tous les comptes en base
	 * @return
	 */
	public ArrayList<Compte> lireListe(){
		
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		int id = 0;
		double solde = 0;
		String typeDeCompte = "inconnu";
		ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();
		Compte compte = null;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM comptes ";
			// etape 4 = execution requete
			rs = st.executeQuery(sql);
			// etape 5 (parcours resultSet)
			while (rs.next()) {
				id = rs.getInt(1);
				typeDeCompte = rs.getString(2);
				solde = rs.getDouble(3);
				compte = new Compte(id, typeDeCompte, solde);
				comptes.add(compte);
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
		return comptes;
		
	}
	/**
	 * suppression en base d'un compte a partir de son id
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
			String sql = "DELETE FROM `comptes` WHERE id = " + id ;
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
	 * vide la table des comptes
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
			String sql = "TRUNCATE TABLE comptes" ;
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
	 * modification du solde d'un compte avec l'id du compte et la valeur du nouveau solde
	 * @param id
	 * @param nouveauSolde
	 * @return
	 */
	public boolean modifierSoldeCompte(int id, double nouveauSolde) {
		

		String insertString = "UPDATE `comptes` SET solde=? WHERE id=" + id;
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			pst = cn.prepareStatement(insertString);
			pst.setDouble(1, nouveauSolde);

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
