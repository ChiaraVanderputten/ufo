package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/ufo_sightings?user=root&password=root");
	}
	
}
