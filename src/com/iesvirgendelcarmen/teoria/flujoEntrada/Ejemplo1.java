package com.iesvirgendelcarmen.teoria.flujoEntrada;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {
		File inFile = new File("datos/fichero3.txt");
		try (FileInputStream in =  new FileInputStream(inFile);){
			int byteALeer;
			while ((byteALeer = in.read()) != -1) // -1 fin de fichero
				System.out.print((char) byteALeer);
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + inFile.getName());
		} catch (IOException e1) {
			System.out.println("Error de lectura");
		}

	}

}
