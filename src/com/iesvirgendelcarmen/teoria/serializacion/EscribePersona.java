package com.iesvirgendelcarmen.teoria.serializacion;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EscribePersona {

	public static void main(String[] args) {
		List<Persona> listaPersonas = new ArrayList<>();
		File outFile = new File("datos/persona.dat");
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse("25/02/2009", formatter);
		LocalDate date2 = LocalDate.parse("15/12/2000", formatter);
		LocalDate date3 = LocalDate.parse("25/03/1998", formatter);

		Persona persona1 = new Persona("Rodríguez Acosta", "Agapito", date1);
		Persona persona2 = new Persona("Rodríguez Rodríguez", "Wenceslao", date2);
		Persona persona3 = new Persona("Acosta Acosta", "Luisita", date3);
		
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);
		listaPersonas.add(persona3);

		try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(outFile)));)
		{
			out.writeObject(listaPersonas);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Escrito fichero %s de tamaño %d bytes%n",
				outFile.getName(), outFile.length());
	}

}
