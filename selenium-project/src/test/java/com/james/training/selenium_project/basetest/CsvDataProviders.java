package com.james.training.selenium_project.basetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.james.training.selenium_project.basetest.db.DBConnectionDAO;
import com.james.training.selenium_project.basetest.db.DatabaseConnectionManager;
import com.opencsv.CSVReader;

public class CsvDataProviders {
	
	@DataProvider(name = "csvNegativeTestReader")
	public static Iterator<Object[]> csvNegativeTestReader(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "dataproviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ method.getName() + ".csv";
		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					list.add(new Object[] { testData });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
		}

		return list.iterator();
	}
	
	@DataProvider(name = "csvPositiveTestReader")
	public static Iterator<Object[]> csvPositiveTestReader(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "dataproviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ method.getName() + ".csv";
		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					
					list.add(new Object[] { testData });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
		}

		return list.iterator();
	}

}
