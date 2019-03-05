package com.iesvirgendelcarmen.teoria.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ejercicio3 {
	public static void main(String[] args) {
		//Crear el path sobre el fichero
		Path inPath = Paths.get("datos", "fundacion.txt");
		if (Files.notExists(inPath)) {
			System.err.println("No existe el fichero " + inPath.toString());
			return;
		}
		try {
			//usando el método readAllLines, leemos todas las líneas
			List<String> listaLineas = Files.readAllLines(inPath);
			//mostramos cuantas líneas tiene el fichero
			System.out.printf("Nº de líneas del fichero %s %d líneas%n",
					inPath.toString(), listaLineas.size());
			//mostrar el nº de ocurrencias de una palabra dada (Trántor)
			String ocurrencia = "Trántor";
			int contador = 0;
			for (String linea : listaLineas) {
				if (linea.contains(ocurrencia))
					contador++;
			}
			
			System.out.printf("Nº de ocurrencias de %s %d veces%n", 
					ocurrencia, contador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
