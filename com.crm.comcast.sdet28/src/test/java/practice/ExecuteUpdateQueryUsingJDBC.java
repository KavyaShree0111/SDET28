package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryUsingJDBC {

	public static void main(String[] args) throws SQLException {
		
		//Register the driver
		 Driver driver = new Driver();
		 DriverManager.registerDriver(driver);
		 
		 //Establish the connection
		 
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		 
		 
		 //Issue of create statement
		 Statement statement = connection.createStatement();
		 
		 
		 //Execute update query
		 
		 int result = statement.executeUpdate("insert into student values(101, 'Sam', 'Sciene');");
		 if(result==1) {
			 System.out.println("Database is updated");
		 }
			 
			 else
			 {
				 System.out.println("Database is not updated");
			 }
		 
		 //Close the database connection
		 
		 connection.close();
		 
		 }
				 
	
}
