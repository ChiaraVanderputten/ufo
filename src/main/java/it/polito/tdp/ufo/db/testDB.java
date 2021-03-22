package it.polito.tdp.ufo.db;



import java.util.List;

public class testDB {
	
	public static void main(String [] args) {
		
		SightingDAO dao = new SightingDAO();
		List<String> formeUFO = dao.readShapes();
		
		for(String forma : formeUFO) {     //ogni volta la connessione viene aprte e chiusa a ogni query questo rallenta il programma (vedremo più avanti)
			int count = dao.countByShape(forma);
			System.out.println("Ufo di forma "+forma+" sono : "+count );
		}
		
	
	}

}
