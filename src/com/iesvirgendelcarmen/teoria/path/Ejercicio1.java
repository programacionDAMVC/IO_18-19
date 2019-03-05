package com.iesvirgendelcarmen.teoria.path;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Path path = new Path("datos"); no se puede hacer, es que no se puede crear objetos de una Interfaz
		Path path = Paths.get("datos", "fichero1.txt");
		System.out.println(path);
		Path pathPadre = path.getParent();
		System.out.println(pathPadre);
		System.out.println(path.getNameCount());
		System.out.println(path.endsWith("fichero1.txt"));
		File filePath = path.toFile();
		System.out.println("Tamaño del fichero " + filePath.length() + " bytes");
		//de acuerdo a documentación:
		Path newPath = FileSystems.getDefault().getPath("datos", "fichero1.txt");
		System.out.println(newPath);

		
	}

}
