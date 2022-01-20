package com.crm.comcast.sdet28GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection connection=null;
	
	/**
	 * This method is will get the connection to Database
	 * @throws SQLException
	 */
	
	public void connectToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 connection = DriverManager.getConnection(IPathConstants.DATABASE_PATH,"root","root");
	}
		
	
	/**
	 * This method will close the connection to Database
	 * @throws Throwable
	 */
	
	public void closeDB() throws Throwable {
	connection.close();
	}
	
	
	/**
	 * This method will update the data in the database and it will verify
	 * @param query
	 * @return
	 * @throws Throwable 
	 */
	public ResultSet getAllData(String query) throws Throwable {
	 ResultSet result = connection.createStatement().executeQuery(query);
	 return result;
	}
	
	
	/**
	 * This method will update the data in database and it will verify
	 * @param query
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public boolean updateData(String query) throws Throwable {
		boolean flag=false;
		int result = connection.createStatement().executeUpdate(query);
		if (result==1) {
			System.out.println("data is updated in database");
			flag=true;
		}else {
			System.out.println("data is not updated in database");
		}
		return flag;
	}
		
	/**
	 * This method will verify the given data is present in the database or not
	 * @param query
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable 
	 */
		public String getTheData(String query, int columnNumber,String expectedData) throws Throwable {
				boolean flag=false;
				String actualData=null;
				 ResultSet result=connection.createStatement().executeQuery(query);
				 while (result.next()) {
					 String data=result.getString(columnNumber);
					 if(data.equals(expectedData)) {
					 actualData=data;
					 flag=true;
					 break;
				 }
		
				 }
				if(flag==true)	{
					System.out.println("Data is present in the database");
				}
				else {
					System.out.println("Data is present in the database");
					return actualData;
				 }
				return actualData;
					 
				 }
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


