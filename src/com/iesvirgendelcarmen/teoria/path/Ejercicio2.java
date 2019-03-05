package com.iesvirgendelcarmen.teoria.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//clase que copia ficheros usando las nuevas 
//utilidades que aporta el paquete nio de java
//en este caso con la clase Files
public class Ejercicio2 {

	public static void main(String[] args) {
		// Definir los path de entrada y salida
		Path inPath = Paths.get("datos", "fundacion.txt");
		Path outPath = Paths.get("datos", "fundacion_back1.txt");
		// Comprobar que el path de entrada existe (mejor si no existe, salimos del programa)
		if (Files.notExists(inPath)) {
			System.err.println("No existe el fichero " + inPath.toString());
			return;
		}
		// Usando el método copy de la clase Files copiamos inPath a outPath
		try {
			Files.copy(inPath, outPath, StandardCopyOption.REPLACE_EXISTING);
			// Mostramos el tamaño del fichero de salida y entrada
			System.out.printf("Tamaño del fichero de entrada %s %d bytes%n",
					inPath.toString(), Files.size(inPath));
			System.out.printf("Tamaño del fichero de entrada %s %d bytes%n",
					outPath.toString(), Files.size(outPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
