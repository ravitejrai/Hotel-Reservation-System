import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class DB_Connection {
	
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/minoa"; 
	   
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	
	
	public int Connect(String query){
			
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				int affectedrows = stmt.executeUpdate(query);

				return affectedrows;
				} 
			 
			catch(SQLException ex) {
				System.out.println("Error in connection: " + ex.getMessage());
				return 0;
			}
	}
	public ResultSet Connection(String query) {	
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		        return rs;
			} 

		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
			return null;
		}
	}
		
}

