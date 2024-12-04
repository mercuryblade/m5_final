package com.edutecno.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/horoscopo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "j89v89";
    private static Connection conn = null;


	private DBConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			if(conn!=null) {
				System.out.println("Conexion Establecida");
			} else {
				System.out.println("No se logro conectar");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		if(conn==null) {
			new DBConnection();
		}
		return conn;
	}
}
