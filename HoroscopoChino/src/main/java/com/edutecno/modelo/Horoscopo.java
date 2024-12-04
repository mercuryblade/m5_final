package com.edutecno.modelo;

import java.sql.Date;

public class Horoscopo {
	private String animal;
	private Date fecha_inicio;
	private Date fecha_fin;

	public Horoscopo(String animal, Date fecha_inicio, Date fechaFin) {
		this.animal = animal;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fechaFin;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fechaFin) {
		this.fecha_fin = fechaFin;
	}


}
