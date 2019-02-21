package com.iesvirgendelcarmen.teoria.flujoSalida;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		File inFile = new File("datos/fundacion.txt");
		File outFile = new File("datos/fundacion_back.txt");
		
		try (Scanner sc = new Scanner(inFile);
		//	 FileOutputStream out = new FileOutputStream(outFile);
			 BufferedOutputStream out = new BufferedOutputStream(
					 new FileOutputStream(outFile) );	){
			while (sc.hasNextLine()) {
		//		System.out.print(sc.nextLine());
				out.write(sc.nextLine().getBytes());
				out.write("\n".getBytes()); //añado salto de línea
				out.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No encuentro fichero/s");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		} 
		System.out.printf("Tamaño del fichero entrada %s es %d bytes%n",
				inFile.getName(), inFile.length());
		System.out.printf("Tamaño del fichero salida %s es %d bytes%n",
				outFile.getName(), outFile.length());
		long fin = System.currentTimeMillis();
		System.out.printf("Tiempo de ejecución: %d ms%n", fin - inicio);

	}

}
