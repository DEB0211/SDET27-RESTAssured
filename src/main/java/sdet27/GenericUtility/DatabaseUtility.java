package sdet27.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains generic methods to connect to database
 * @author Chaitra M
 *
 */
public class DatabaseUtility {
	
	Connection con = null;
	//Step 1: register the database---1
	//Step 2: get connection with DB---1
	//Step 3: issue create statement---2
	//Step 4: execute Query--2
	//Step 5: close connection----3
	/**
	 * this method will establish connection with database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
	}
	
	/**
	 * this method will execute query and return the data present in database
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
				flag = true;//rising flag
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData+"    Data verified");
			return expData;
		}
		else
		{
			System.out.println("data not present");
			return "";
		}
	}
	
	
	/**
	 * this method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}

}
