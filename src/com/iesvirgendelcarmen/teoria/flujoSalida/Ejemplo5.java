package com.iesvirgendelcarmen.teoria.flujoSalida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo5 {

	public static void main(String[] args) {
		// crear un objeto File para el fichero de salida
		File outFile = new File("datos/fichero3.txt");
		// crear un lista de String para añadir distintas líneas
		List<String> listaCadenas = new ArrayList<>(); //lista vacía pero no null
		// añadimos las líneas
		listaCadenas.add("En un lugar de la Mancha");
		listaCadenas.add("de cuyo nombre no quiero acordarme");
		listaCadenas.add("no ha mucho tiempo que vivı́a un hidalgo");
		listaCadenas.add("de los de lanza en astillero,");
		listaCadenas.add("adarga antigua, rocı́n flaco y galgo corredor.");
		// definimos bufferedwriter y excepciones según java 7
		try (BufferedWriter out = new BufferedWriter(
					new FileWriter(outFile));){
			// escribimos en el buffer
			for (String string : listaCadenas) {
				out.write(string);
				out.newLine();
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hecho");

	}

}
