package com.iesvirgendelcarmen.teoria.serializacion;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EscribePersona {

	public static void main(String[] args) {
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("25/02/2009", formatter);
		Persona persona = new Persona("Rodríguez Acosta", "Agapito", date);
		try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(new File("datos/persona.dat"))));)
		{
			out.writeObject(persona);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
