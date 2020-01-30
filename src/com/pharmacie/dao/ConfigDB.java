package com.pharmacie.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigDB {
	private static ConfigDB instance;
	
	private ConfigDB() {
		
	}
	
	public static ConfigDB getInstance() {
		if(instance == null) {
			instance = new ConfigDB();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/db_pharmacie", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return connection;
				
		
	}
	
	
}
