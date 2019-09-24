package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleSourceConnection {

	private static Connection sourceConn;
	private static Connection destinationConn;

	public static Connection getSoruceConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				sourceConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "LMS1", "LMS1");
				sourceConn.setAutoCommit(true);
			} catch (SQLException ex) {
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
		}
		return sourceConn;
	}
	
	public static Connection getDestinationConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				destinationConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "LMS2", "LMS2");
				destinationConn.setAutoCommit(true);
			} catch (SQLException ex) {
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
		}
		return destinationConn;
	}
}
