package com.iesvirgendelcarmen.exercises;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
	private static Connection connection;
	private ConnectionDB() {}
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		final String URL = properties.getProperty("JDBC") + properties.getProperty("DB");
		System.out.println(URL);
		if (connection == null) {
			
			connection = DriverManager.getConnection(URL);
		}
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
