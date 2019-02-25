package com.iesvirgendelcarmen.teoria.flujoEntrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo4 {
	public static void main(String[] args) {

		//crear el objeto File que apunte a fundacion.txt
		File inFile = new File("datos/fundacion.txt");
		//crear el flujo de entrada tipo caracter bufferedreader
//		try (BufferedReader in = new BufferedReader(new FileReader(inFile));) {
//			String lineaLeida;
//			int contadorLineas = 0;
//			int contadorMallow = 0;
//			while ((lineaLeida = in.readLine()) != null) {
//				//System.out.println(lineaLeida);
//				if (lineaLeida.contains("Mallow"))
//					contadorMallow++;
//				contadorLineas++;
//			}
//			System.out.printf("Número de líneas leídas %d%n", contadorLineas);
//			System.out.printf("Número de líneas donde aparece la palabra %s %d%n",
//					"Mallow" , contadorMallow);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try (BufferedReader in = new BufferedReader(new FileReader(inFile));){
			int caracterLeido;
			while ((caracterLeido = in.read()) != -1)
				System.out.print((char) caracterLeido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
