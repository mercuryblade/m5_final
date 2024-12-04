package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.DBConnection;


public class UsuarioDAO {


	public void addUsuario(Usuario u) {
		String sql = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password, animal) VALUES (?,?,?,?,?,?)";
		Connection cnx = DBConnection.getConnect();
		try {
			PreparedStatement stmt = cnx.prepareStatement(sql);
			stmt.setString(1, u.getNombre());
			stmt.setString(2, u.getUser());
			stmt.setString(3, u.getEmail());
			stmt.setDate(4, java.sql.Date.valueOf(u.getFecha_nacimiento()));
			stmt.setString(5, u.getPass());
			stmt.setString(6, u.getAnimal());
			int fila = stmt.executeUpdate();
			if (fila > 0) {
				System.out.println("Usuario agregado");
			} else {
				System.out.println("Algo ocurrio al añadir el usuario");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> getAllUsuarios() throws SQLException {
	    List<Usuario> usuarios = new ArrayList<>();
	    String query = "SELECT * FROM usuarios";
	    Connection cnx = DBConnection.getConnect();
	    try {
	        PreparedStatement stmt = cnx.prepareStatement(query);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            Usuario u = new Usuario();
	            u.setUser(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
	            u.setAnimal(rs.getString("animal"));
	            usuarios.add(u);
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return usuarios;
	}


	public List<Usuario> searchUsuarios(String searchTerm) throws SQLException {
	    List<Usuario> usuarios = new ArrayList<>();
	    String query = "SELECT * FROM usuarios WHERE username ILIKE ? OR email ILIKE ?";
	    Connection cnx = DBConnection.getConnect();
	    try {
	        PreparedStatement stmt = cnx.prepareStatement(query);
	        stmt.setString(1, "%" + searchTerm + "%");
	        stmt.setString(2, "%" + searchTerm + "%");
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            Usuario u = new Usuario();
	            u.setUser(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
	            u.setAnimal(rs.getString("animal"));
	            usuarios.add(u);
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return usuarios;
	}


	public Usuario getUsuarioById(int id) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		Usuario u = new Usuario();
		Connection cnx = DBConnection.getConnect();
		try {
			PreparedStatement pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setUser (rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
				u.setAnimal(rs.getString("animal"));
				u.setPass(rs.getString("password"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


	public Usuario getUsuarioByUsername(String user) throws SQLException {
	    String sql = "SELECT * FROM usuarios WHERE username = ?";
	    Usuario u = null;
	    Connection cnx = DBConnection.getConnect();
	    try {
	        PreparedStatement pstmt = cnx.prepareStatement(sql);
	        pstmt.setString(1, user);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            u = new Usuario();
	            u.setId(rs.getInt("id"));
	            u.setNombre(rs.getString("nombre"));
	            u.setUser (rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
	            u.setAnimal(rs.getString("animal"));
	            u.setPass(rs.getString("password")); //
	        }
	        rs.close();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return u;
	}

	public void updateUsuario(Usuario u) {
		String query = "UPDATE usuarios SET nombre = ?, username = ?, email = ?, fecha_nacimiento = ?, password = ?, animal = ? WHERE id = ?";
		try {
			Connection cnx = DBConnection.getConnect();
			PreparedStatement stmt = cnx.prepareStatement(query);
			stmt.setString(1, u.getNombre());
			stmt.setString(2, u.getUser());
			stmt.setString(3, u.getEmail());
			stmt.setDate(4, java.sql.Date.valueOf(u.getFecha_nacimiento()));
			stmt.setString(5,u. getPass());
			stmt.setString(6, u.getAnimal());
			stmt.setInt(7, u.getId());
			int fila = stmt.executeUpdate();
			if(fila > 0) {
				System.out.println("Usuario actualizado");
			}else {
				System.out.println("Problema al actualizar el usuario");

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUsuario(int id) {
		String query = "DELETE FROM usuarios WHERE id = ?";
		try {
			Connection cnx = DBConnection.getConnect();
			PreparedStatement stmt = cnx.prepareStatement(query);
			stmt.setInt(1, id);
			int fila = stmt.executeUpdate();
			if(fila > 0) {
				System.out.println("Usuario eliminado");
			}else {
				System.out.println("Problema al eliminar el Usuario");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 public boolean existsByUsername(String username) {
	    String query = "SELECT COUNT(*) FROM usuarios WHERE username = ?";
	    Connection cnx = DBConnection.getConnect();
	    try {
	        PreparedStatement stmt = cnx.prepareStatement(query);
	        stmt.setString(1, username);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0; //
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean existsByEmail(String email) {
	    String query = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
	    Connection cnx = DBConnection.getConnect();
	    try {
	        PreparedStatement stmt = cnx.prepareStatement(query);
	        stmt.setString(1, email);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0; //
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
