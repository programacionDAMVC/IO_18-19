package com.iesvirgendelcarmen.teoria.serializacion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LectorPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(new File("datos/persona.dat"))));){
			Persona persona = (Persona) in.readObject();
			System.out.println(persona);
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
