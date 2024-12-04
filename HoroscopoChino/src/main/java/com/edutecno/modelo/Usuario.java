package com.edutecno.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.edutecno.dao.HoroscopoDAO;

public class Usuario {
	private int id;
	private String nombre;
	private String user;
	private String email;
	private LocalDate fecha_nacimiento;
	private String pass;
	private String animal;

	public Usuario() {

	}

	public Usuario(String nombre, String user, String email, LocalDate fecha_nacimiento, String pass) {
		this.nombre = nombre;
		this.user = user;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.pass = pass;
		try {
			this.animal = getZodiac();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getZodiac() throws SQLException {
        List<Horoscopo> listaHoroscopo = (new HoroscopoDAO()).obtenerHoroscopo();
        Horoscopo horoscopo = null;

        for (Horoscopo temp : listaHoroscopo) {
            LocalDate fechaInicio = temp.getFecha_inicio().toLocalDate();
            LocalDate fechaFin = temp.getFecha_fin().toLocalDate();

            if ((fecha_nacimiento.isAfter(fechaInicio) && fecha_nacimiento.isBefore(fechaFin)) ||
                fecha_nacimiento.isEqual(fechaInicio) || fecha_nacimiento.isEqual(fechaFin)) {
                horoscopo = temp;
                break;
            }
        }

        if (horoscopo != null) {
            this.setAnimal(horoscopo.getAnimal());
        }
		return animal;
    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", user=" + user + ", email=" + email
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", pass=" + pass + ", animal=" + animal + "]";
	}


}
