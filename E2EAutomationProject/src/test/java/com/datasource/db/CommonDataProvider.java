/**
 * 
 */
package com.datasource.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.datasource.excel.ReadDataFromExcel;
import com.opencsv.CSVReader;


/**
 * @author james.ngondo
 *
 */


public class CommonDataProvider {

    private static List<UserDetails> userDetails;
    private static ArrayList<String> user;
    private static ArrayList<String> pw;
    
    
    public static void main (String[] args)
    {
        getData ();
    }
    
    @DataProvider(name = "csvPositiveTestReader")
	public Iterator<Object[]> csvPositiveTestReader(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "logindata.csv";
		
		String csvFilePath = "scr/main/java/com/datasource/excel/logindata.csv";
		
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


    @DataProvider(name="getData",parallel=true)
    public static  Object[][] getData ()
    {
        user = new ArrayList<String>();;
        pw = new ArrayList<String>();
        Object[][] data;
        
        userDetails = new ArrayList<UserDetails>();
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automation", "root", "chingotah1980");

            if (con != null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * FROM automation.employeeinfo");
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");

                    userDetails.add(new UserDetails(username, password));
               
                }

            }

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("cannot connect to database...");
        }
        
        for (UserDetails val : userDetails) {
            //System.out.println(val.getUsername());
            //System.out.println(val.getPassword());
            
            pw.add(val.getPassword());
            user.add(val.getUsername());
        }
 
        data = new Object[userDetails.size()][2];
        
        for (int i = 0; i < user.size(); i++) {
            data[i][0] = user.get(i).toString();
              
            for (int j = 0; j < pw.size(); j++) {
                data[j][1] = pw.get(j).toString();
          }
        }
       
    
     /* for (int i = 0; i < data.length; i++) {
         System.out.print(data[i][0].toString());
         System.out.println(" " + data[i][1].toString());
          
      }*/
      
        return data;
    }
    
    @DataProvider(name="getDataExcel",parallel=true)
    public Object[][] getDataExcel ()
    {
        ArrayList<String> username = ReadDataFromExcel.excelUserLoginDetails(0);
        ArrayList<String> password = ReadDataFromExcel.excelUserLoginDetails(1);
        int size = password.size();

        Object[][] data = new Object[size][2];

        for (int i = 0; i < username.size(); i++) {
            data[i][0] = username.get(i).toString();

            for (int j = 0; j < password.size(); j++) {
                data[j][1] = password.get(j).toString();
            }
        }

        // [size]= row - stands for how many times different data types the test should
        // e.g 2 times
        // run
        // [2]= col- stands for how many values per each test eg (username,
        // password)

        // ===Data type 1
        /* data[0][0] = "nonresticteduser@gmail.com";
         data[0][1] = "123456";
*/
        // ===Data type 2
         /*data[1][0] = "resticteduser@gmail.com";
         data[1][1] = "45678";
*/
        return data;

    }
}
