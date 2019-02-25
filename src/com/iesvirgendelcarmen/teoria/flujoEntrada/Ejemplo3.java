//programa que lee un fichero y hace una copia del mismo
package com.iesvirgendelcarmen.teoria.flujoEntrada;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo3 {

	public static void main(String[] args) {
		//nombre de fichero de salida y de entrada
		final String DIRECTORIO = "datos/";
		final String NOMBRE_FICHERO = "imagen";
		final String COPIA_FICHERO  = NOMBRE_FICHERO + "_back";
		final String EXTENSION      = ".png";

		//descriptores de los ficheros de entrada y salida
		File inFile  = new File (DIRECTORIO + NOMBRE_FICHERO + EXTENSION);
		File outFile = new File (DIRECTORIO + COPIA_FICHERO + EXTENSION);

		//flujos de salida y entrada, con buffer
		try (BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(inFile));
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(outFile));) {
			//lectura del fichero
			int byteLeido;
			while (( byteLeido = in.read() ) != -1 ) {
				//escribimos en el flujo de salida
				//System.out.println(byteLeido);
				out.write(byteLeido % 256);
			}
			out.flush();
			System.out.println("FIN DE FICHERO: " + byteLeido);

		} catch (FileNotFoundException e) {
			System.out.println("No encuentra fichero");
		} catch (IOException e1) {
			System.out.println("Erros I/O");
		}
		if (inFile.length() == outFile.length())
			System.out.println("Ficheros de igual capacidad");


	}

}
