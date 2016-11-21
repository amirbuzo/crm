package com.crm.report.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static Connection getConnection() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433/CRM",
					"crm", "crm");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}