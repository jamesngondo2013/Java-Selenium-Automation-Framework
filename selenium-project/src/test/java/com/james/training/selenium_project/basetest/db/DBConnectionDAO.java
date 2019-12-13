package com.james.training.selenium_project.basetest.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.james.training.selenium_project.basetest.TestDataDetails;

public class DBConnectionDAO {

	private static DBConnectionDAO DAOINSTANCE;

	static String id;
	static String username;
	static String password;
	static String expected_message;
	static String description;

	static List<TestDataDetails> testData;

	private DBConnectionDAO() {

	}

	public static synchronized DBConnectionDAO getINSTANCE() {

		if (DAOINSTANCE == null) {
			DAOINSTANCE = new DBConnectionDAO();
		}
		return DAOINSTANCE;
	}

	public static void main(String[] args) {
		DBConnectionDAO dao = DBConnectionDAO.getINSTANCE();
		// dao.getData();
		getData();

	}

	public static List<TestDataDetails> getData() {

		DatabaseConnectionManager con = DatabaseConnectionManager.getConnectionManagerInstance();
		con.connect();

		Statement stmt = null;
		ResultSet rs = null;
		testData = new ArrayList<TestDataDetails>();

		try {
			stmt = con.getConn().createStatement();
			rs = stmt.executeQuery("select * FROM automation.negative_login_test_data");

			while (rs.next()) {
				id = rs.getString("id");
				username = rs.getString("username");
				password = rs.getString("password");
				expected_message = rs.getString("expected_message");
				description = rs.getString("description");

				testData.add(new TestDataDetails(id, password, username, expected_message, description));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("cannot connect to database...");
		}
		
		return testData;

	}
}
