package com.datasource.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection
{
    static List<UserDetails> userDetails;
    
    public List<UserDetails> getData(){

        userDetails = new ArrayList<UserDetails>();
        Connection con = null;
        try {
            con = (Connection)DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/automation", "root", "chingotah1980");
            
            if (con!=null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(
                    "select * FROM automation.employeeinfo");
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    
                    userDetails.add(new UserDetails(username,password));
                   // System.out.println("Username:" + username);
                   // System.out.println("Password:" + password);
                   
                }
               
            }
         
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("cannot connect to database...");
        }
        return userDetails;
    }
}
