package pages;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	
	String columnValue = "null";
	Connection connection = null; 
	Statement statement = null;
	ResultSet rs = null;
	/*if you have more than one column to access from DB, you gonna have to use the ListArray function
	List<String> dataList = new ArrayList<String>();
	use a ForLoop instead of a WhileLoop*/
	
	
	public String getData(String columnName) throws SQLException {
		
		try {
			// setting properties for mysql
		    Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/june2021";
			String sqlUsername = "root";
			String sqlPassword = "Mysqlearning1#";
			String query = "Select* from users"; 
			
			//Create connection to local database
			Connection connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			
			//empowering the connection reference variable to execute queries
			Statement statement = connection.createStatement();
			
			//Delivering the query
			 ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				columnValue = rs.getString(columnName);
				return columnValue;
			}
			
			
			} catch(Exception e) {e.printStackTrace();}
		finally { 
			if (rs !=null) {rs.close();
			    }
			   
			if (connection!=null) { connection.close();
			           } 
		}
		return columnValue;
		
	
  }
}
