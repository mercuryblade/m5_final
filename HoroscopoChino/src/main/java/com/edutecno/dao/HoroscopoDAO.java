package com.edutecno.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.DBConnection;


public class HoroscopoDAO {
	public List<Horoscopo> obtenerHoroscopo() throws SQLException{
		List<Horoscopo> horoscopos = new ArrayList<>();
		String sql = "SELECT * FROM horoscopo";
		Connection cnx = DBConnection.getConnect();
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				horoscopos.add(new Horoscopo(rs.getString("animal"), rs.getDate("fecha_inicio"),
						rs.getDate("fecha_fin")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horoscopos;
	}
}
