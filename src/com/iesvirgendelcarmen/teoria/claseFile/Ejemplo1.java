package com.iesvirgendelcarmen.teoria.claseFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		System.out.println("Introduce el path del fichero a estudiar");
		Scanner sc = new Scanner(System.in);
		String nombreFichero = sc.next();
		sc.close();
		// crear objeto File que apunte a la carpeta datos
		File fichero = new File(nombreFichero);
		if ( !fichero.exists()) {
			System.err.println("No existe el fichero");
			System.exit(1);
		}
		// obtener la lista de ficheros 
		File[] ficheros = fichero.listFiles();
		// llamar a un método estático con argumento otro File que nos de atributos
		// del fichero: tamaño, si es un directorio, saber los permisos rwx
//		for (File file : ficheros) {
//			mostrarDatosFichero(file);
//		}
		List<File> listaFicheros = Arrays.asList(ficheros);
//		for (File file : listaFicheros) {
//			mostrarDatosFichero(file);
//		}
		listaFicheros.forEach(file -> mostrarDatosFichero(file));
		
	}
	
	public static void mostrarDatosFichero(File file) {
		System.out.println("=============================");
		System.out.printf("Nombre del fichero %s%n", file.getAbsoluteFile());
		System.out.printf("Tamaño del fichero %d bytes%n", file.length() );
		System.out.printf("Tiene permiso de lectura %B%n", file.canRead());
		System.out.printf("Tiene permiso de escritura %B%n", file.canWrite());
		System.out.printf("Tiene permiso de ejecución %B%n", file.canExecute());
		System.out.printf("Es directorio %B%n", file.isDirectory());
		System.out.println("=============================");

	}

}
