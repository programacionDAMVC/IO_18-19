//flujo salida caracter
package com.iesvirgendelcarmen.teoria.flujoSalida;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo4 {

	public static void main(String[] args) {
		
		String frase = "Ejemplo con una eñe";
		try (FileWriter out = new FileWriter("datos/fichero2.txt");){
			out.write(frase);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hecho");
		
//		String frase = "Ejemplo con una eñe";
//		char[] arrayChar = frase.toCharArray();
//		try (FileWriter out = new FileWriter("datos/fichero2.txt");){
//			out.write(arrayChar);
//			out.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("hecho");
		
//		String frase = "Ejemplo con una eñe";
//		char[] arrayChar = frase.toCharArray();
//		try (FileWriter out = new FileWriter("datos/fichero2.txt");){
//			for (char c : arrayChar) {
//				out.write(c);
//				out.flush();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("hecho");
	}

}
