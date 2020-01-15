package com.datasource.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager
{
	private static DatabaseConnectionManager connectionManagerInstance;
	private Connection conn;
	
	public static DatabaseConnectionManager getConnectionManagerInstance() {
		
		if (connectionManagerInstance==null) {
			connectionManagerInstance = new DatabaseConnectionManager();
		}
		return connectionManagerInstance;
	}

	public Connection connect() {
	        
		 try {
	            conn = (Connection)DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/automation?useSSL=false&amp", "root", "chingotah9070");
	            
	            if (conn!=null) {
	                System.out.println("successfully connected to database...");
	            }
	         
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("cannot connect to database...");
	        }
		 
		return conn;
	}

	public void disconnectDB() throws SQLException{
		conn.close();
		System.out.println("Disconnected from database...");
	}
}
