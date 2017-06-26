package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AccesDao {
	// information d'accces a la base de donnees
	String url = "jdbc:mysql://localhost/formation";
	String login = "root";
//	String passwd = "root";
	String passwd = "";
	Connection cn = null;
	Statement st = null;
	PreparedStatement pst = null;
	java.sql.ResultSet rs = null;

}
