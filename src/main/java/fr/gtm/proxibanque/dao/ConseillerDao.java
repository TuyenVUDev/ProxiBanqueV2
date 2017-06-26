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

public class ConseillerDao extends AccesDao{

	ConseillerClientCRUDDao conseillerClientCRUDDao = new ConseillerClientCRUDDao();
	ConseillerCompteCRUDDao conseillerCompteCRUDDao = new ConseillerCompteCRUDDao();
	
	public boolean associerCompteCourant(int idCompte, int idClient) {
		
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st=cn.createStatement();
			// etape 4 = execution requete
			String sql = "UPDATE `clients` SET `idCompteCourant`="+idCompte+" WHERE id="+idClient;
			st.executeUpdate(sql);
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
	
	
public boolean associerCompteEpargne(int idCompte, int idClient) {
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, log, passwd);
			// etape 3 : creation d'un statement
			st=cn.createStatement();
			// etape 4 = execution requete
			String sql = "UPDATE `clients` SET `idCompteEpargne`="+idCompte+" WHERE id="+idClient;

			st.executeUpdate(sql);

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
	
}
