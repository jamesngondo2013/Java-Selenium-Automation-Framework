package com.james.training.selenium_project.basetest.db;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.james.training.selenium_project.basetest.TestDataDetails;

public class DBDataProvider {

	private static List<TestDataDetails> testDetails;

	public DBDataProvider() {

	}

	@DataProvider(name = "getDBData", parallel = true)
	public static Object[][] getDBData() {
		ArrayList<String> user = new ArrayList<String>();
		;
		ArrayList<String> pw = new ArrayList<String>();
		Object[][] data;

		testDetails = DBConnectionDAO.getTestDBData();

		for (TestDataDetails val : testDetails) {
			// System.out.println(val.getUsername());
			// System.out.println(val.getPassword());

			pw.add(val.getPassword());
			user.add(val.getUsername());
		}

		data = new Object[testDetails.size()][2];

		for (int i = 0; i < user.size(); i++) {
			data[i][0] = user.get(i).toString();

			for (int j = 0; j < pw.size(); j++) {
				data[j][1] = pw.get(j).toString();
			}
		}

		return data;
	}

	/*
	 * @DataProvider(name = "getData", parallel = true) public Object[][] getData()
	 * {
	 * 
	 * Object[][] data = new Object[size][2];
	 * 
	 * // [size]= row - stands for how many times different data types the test
	 * should // e.g 2 times // run // [2]= col- stands for how many values per each
	 * test eg (username, // password)
	 * 
	 * // ===Data type 1 data[0][0] = "nonresticteduser@gmail.com"; data[0][1] =
	 * "123456";
	 * 
	 * // ===Data type 2 data[1][0] = "resticteduser@gmail.com"; data[1][1] =
	 * "45678";
	 * 
	 * data[1][0] = "resticteduser@gmail.com"; data[1][1] = "45678";
	 * 
	 * data[1][0] = "resticteduser@gmail.com"; data[1][1] = "45678";
	 * 
	 * return data;
	 * 
	 * }
	 */

}
