package com.iesvirgendelcarmen.teoria.serializacion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LectorPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(new File("datos/persona.dat"))));){
			List<Persona> listaPersonas =  (List<Persona>) in.readObject();
			
			
			for (Persona persona : listaPersonas) {
				System.out.println(persona);
			}
			
			listaPersonas.forEach(persona -> System.out.println(persona.getApellidosPersona()));
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
