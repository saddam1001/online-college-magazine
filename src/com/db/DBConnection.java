package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection(){
		Connection con=null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection(
			"jdbc:oracle:thin:SCOTT/TIGER@localhost:1521/PDBORCL"
			);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
