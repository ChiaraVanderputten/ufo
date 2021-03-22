package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	//qua è dove dichiarerò dei metodi per il DAO
	
	
	
	public List<String> readShapes(){
		try {
		Connection conn = DBConnect.getConnection();
	    //come un tunnel che collega il mio programma con il database
	
		String sql = "SELECT DISTINCT shape FROM sighting WHERE shape<>'' ORDER BY shape ASC";
      	
		PreparedStatement st = conn.prepareStatement(sql); //dammi una navetta in cui mettere dentro una query
		
		//query la passo al momento della preparazione dello statement
		
		
		//chiediamo di darci il risultato della query
		ResultSet res = st.executeQuery();
		
		List <String> formeUFO =new ArrayList <String> ();
		while(res.next()) {
			
			String forma = res.getString("shape"); //dato nella colonna che si chiama shape che avevo messo nella query sql
			formeUFO.add(forma);
			
		}
		st.close(); //rilascia le risorsse 
		conn.close();
		
		return formeUFO;
		}catch(SQLException e) {
			throw new RuntimeException("Database error in readShapes",e); //ribalto ecezione al chiamante
			
		}
	}
	
	public int countByShape (String shape) {
		
		try {
			
			Connection conn = DBConnect.getConnection();
			String sql2 = "SELECT COUNT(*) AS cnt FROM sighting WHERE shape = ? ";
			
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, shape); //al primo punto interrogativo va sostituito questo valore
			ResultSet res2 = st2.executeQuery(); //nessun parametro perchè sa già che dovrà mandare la query con il paramtro che ho settato
		
			res2.first(); //so che è anche l'ultima perchè mi da solo un valore, allora non faccio ciclo while ma psiziono il cursore sulla prima riga
			int count = res2.getInt("cnt");
			st2.close();
			
			conn.close();
			return count;
			
		}catch(SQLException e) {
			throw new RuntimeException("Database error in readShapes",e); //ribalto ecezione al chiamante
			
		}
		
	}

}
