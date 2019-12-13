package com.james.training.selenium_project.basetest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

import com.james.training.selenium_project.basetest.db.DatabaseConnectionManager;

public class DBDataProvider {
	
	private static  Object[][] data;

	@DataProvider(name = "csvNegativeTestDBReader")
	public static Object[][] csvNegativeTestDBReader() {
		DatabaseConnectionManager con = DatabaseConnectionManager.getConnectionManagerInstance();
		con.connect();

		Statement stmt = null;
		ResultSet rs = null;
		
		// Object[][] data = null;
		 
		 String username = null;
		 String id = null;
		 String password = null;
		 String expected_message=null;
		 String description=null;
	
		try {
			stmt = con.getConn().createStatement();
			rs = stmt.executeQuery("select * FROM automation.negative_login_test_data");
			
			 int colCount = rs.getMetaData().getColumnCount();
			 
			 rs.last();
			 int rowCount = rs.getRow();
			 rs.beforeFirst();
			 
			
			 
			 data = new Object[rowCount][colCount];
			 
			 System.out.println("col: "+ colCount);
			 System.out.println("row: "+ rowCount);
			 
			 int row =0;

			while (rs.next()) {
				
				id = rs.getString("id");
				username = rs.getString("username");
				password = rs.getString("password");
				expected_message = rs.getString("expected_message");
				description = rs.getString("description");
				
				/*System.out.println("csvNegativeTestDBReader: "+id);
				System.out.println("csvNegativeTestDBReader: "+username);
				System.out.println("csvNegativeTestDBReader: "+password);
				System.out.println("csvNegativeTestDBReader: "+expected_message);
				System.out.println("csvNegativeTestDBReader: "+description);*/
				
				

				 for (int i = 0; i < colCount; i++) {
					 data[i][row] = rs.getObject(i+1);
					 System.out.println("i: "+data[i][row]);
					
					 
					 for (int j = 0; j < colCount; j++) {
						data[j][i] = rs.getObject(j+1);
						//System.out.println("j: "+ data[j][i+1]);
					 }
					 
					
			        }
			        row++;
			        
			        System.out.println("============");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("cannot connect to database...");
		}
		
		 for (int i = 0; i < data.length; i++) {
			
			 //System.out.println("i: "+data[i][0]);
			
			 
			 for (int j = 0; j < data.length; j++) {
				
				//System.out.println("j: "+ data[j][i]);
			 }
			 
			
	        }

		
		return data;
		
		
	}

}
