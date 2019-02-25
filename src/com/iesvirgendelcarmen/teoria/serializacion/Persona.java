package com.iesvirgendelcarmen.teoria.serializacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class Persona implements Serializable{

	private String apellidosPersona;
	private String nombrePersona;
	private LocalDate fechaNacimiento;

	public Persona (String apellidosPersona, String nombrePersona, LocalDate fechaNacimiento) {
		this.apellidosPersona = apellidosPersona;
		this.nombrePersona = nombrePersona;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getApellidosPersona() {
		return apellidosPersona;
	}

	public void setApellidosPersona(String apellidosPersona) {
		this.apellidosPersona = apellidosPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return apellidosPersona +", " + nombrePersona + ", edad " + calcularEdad();
	}

	private int calcularEdad() {
		Period period = Period.between(fechaNacimiento, LocalDate.now());
		return period.getYears();
	}

	public static void main(String[] args) {
//		DateTimeFormatter formatter =
//				DateTimeFormatter.ofPattern("dd/MM/yyyy");  //fecha viene como 10/10/2000
//		LocalDate date = LocalDate.parse("25/02/2019", formatter);
//		System.out.printf("%s%n", date);
//		LocalDate newDate = LocalDate.of(2000, 11, 2);
//		System.out.printf("%s%n", newDate);
//		LocalDate newDate1 = LocalDate.of(25, 02, 19);
//		System.out.printf("%s%n", newDate1);
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("25/02/2009", formatter);
		Persona persona = new Persona("Rodríguez Acosta", "Agapito", date);
		System.out.println(persona);



	}










}
