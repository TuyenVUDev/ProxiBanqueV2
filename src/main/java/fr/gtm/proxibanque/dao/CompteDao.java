package fr.gtm.proxibanque.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;

public class CompteDao extends AccesDao{

	public boolean ajouterEnBase(Compte compte) {

		String typeDeCompte=compte.getTypeDeCompte();
		float solde=compte.getSolde();
		
		
		String insertString = "INSERT INTO `clients` ( `typeDeCompte`, `solde`) VALUES(?,?)";
		
		try {
			// Etape 1 : chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etape 2 : recuperation de la connection
			cn = DriverManager.getConnection(url, login, passwd);
			// etape 3 : creation d'un statement
			pst=cn.prepareStatement(insertString);
			pst.setString(2,typeDeCompte);
			pst.setFloat(3,solde);
			
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
}
